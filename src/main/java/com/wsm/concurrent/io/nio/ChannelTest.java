package com.wsm.concurrent.io.nio;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * Created by wangsm on 2018/6/28.
 */
public class ChannelTest {


    public static void main(String[] args) {


        System.out.println(SelectionKey.OP_ACCEPT);


        try {
            int port = 8080;
            //打开ServerSocketChannel ,用于监听客户端的连接，他是所有客户端连接的父管道
            ServerSocketChannel acceptorSvr = ServerSocketChannel.open();
            //绑定监听端口，设置连接为非阻塞模式，
            acceptorSvr.socket().bind(new InetSocketAddress(InetAddress.getByName("IP"), port));
            acceptorSvr.configureBlocking(false);
            //创建Reactor线程，创建多路复用器并启动线程
            Selector selector = Selector.open();
//            new Thread(new ReactorTask()).start();
            //将ServerSocketChannel 注册到Reactor线程的多路复用器Selector上，监听ACCEPT事件
//            SelectionKey key = acceptorSvr.register(selector,SelectionKey.OP_ACCEPT,io);



        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
