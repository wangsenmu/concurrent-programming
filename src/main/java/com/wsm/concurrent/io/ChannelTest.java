package com.wsm.concurrent.io;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by wangsm on 2018/6/27.
 */
public class ChannelTest {


    public static void main(String[] args) throws  Exception{

        RandomAccessFile file =new RandomAccessFile("data.txt","rw");
        FileChannel fileChannel = file.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(48);

        int bytesRead = fileChannel.read(buffer);
        while(bytesRead!=-1){

            System.out.println("read:"+bytesRead);
            buffer.flip();
            while(buffer.hasRemaining()){
                System.out.println((char)buffer.get());
            }
            buffer.clear();
            bytesRead = fileChannel.read(buffer);
        }
        file.close();

    }
}
