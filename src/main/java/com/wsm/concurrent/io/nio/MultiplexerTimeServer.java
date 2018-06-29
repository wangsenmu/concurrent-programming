package com.wsm.concurrent.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by wangsm on 2018/6/28.
 */
public class MultiplexerTimeServer implements Runnable {


    private Selector selector;

    private ServerSocketChannel serverSocketChannel;
    private volatile boolean stop;

    /**
     * 初始化多路复用器，绑定监听接口
     *
     * @param port
     */
    public MultiplexerTimeServer(int port) {
        try {
            this.selector = Selector.open();
            this.serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);
            serverSocketChannel.socket().bind(new InetSocketAddress(port), 1024);
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("The time server is start in port :" + port);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void stop() {
        this.stop = true;
    }

    public void run() {

        while (!stop) {
            try {
                //休眠时间1秒，不管是否有读写事件发生selector每隔1秒都被唤醒一次，
                // selector也提供无参select方法：当有处于就绪状态的Channel时，
                // selector将返回该channel的SelectionKey集合，通过就绪状态的channel集合进行迭代，可以进行网络的异步读写操作
                selector.select(1000);
                Set<SelectionKey> selectionKeySet = selector.selectedKeys();
                Iterator<SelectionKey> it = selectionKeySet.iterator();
                SelectionKey selectionKey = null;
                while (it.hasNext()) {
                    selectionKey = it.next();
                    it.remove();
                    try {
                        handleInput(selectionKey);
                    } catch (Exception e) {
                        if (selectionKey != null) {
                            selectionKey.cancel();
                            if (selectionKey.channel() != null) {
                                selectionKey.channel().close();
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //多路复用器关闭后，所有注册在上面的channel 和Pipe等资源都会被自动去注册并关闭，所以不需要重复释放资源
        if (selector != null)
            try {
                selector.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    private void handleInput(SelectionKey selectionKey) throws IOException {
        if (selectionKey.isValid()) {
            //处理新接入的请求消息
            if (selectionKey.isAcceptable()) {
                //accept the new connection
                ServerSocketChannel ssc = (ServerSocketChannel) selectionKey.channel();
                SocketChannel sc = ssc.accept();

                sc.configureBlocking(false);
                //add the new connection to the selector
                sc.register(selector, SelectionKey.OP_READ);
            }
            if (selectionKey.isReadable()) {
                //read the data
                SocketChannel sc = (SocketChannel) selectionKey.channel();
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                int readBytes = sc.read(readBuffer);
                if (readBytes > 0) {
                    readBuffer.flip();
                    byte[] bytes = new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    String body = new String(bytes, "UTF-8");
                    System.out.println("The time server receive order :" + body);
                    String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "BAD ORDER";

                    doWrite(sc, currentTime);
                } else if (readBytes < 0) {
                    //对端链路关闭
                    selectionKey.cancel();
                    sc.close();
                } else ;//读到0个字节，忽略

            }
        }
    }


    private void doWrite(SocketChannel channel, String response) throws IOException {

        if (response != null && response.trim().length() > 0) {
            byte[] bytes = response.getBytes();
            ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
            writeBuffer.put(bytes);
            writeBuffer.flip();
            channel.write(writeBuffer);
        }
    }

}

