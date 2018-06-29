package com.wsm.concurrent.executor;

import com.sun.corba.se.impl.transport.SelectorImpl;
import com.sun.nio.file.ExtendedOpenOption;

import java.io.IOException;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;
import java.nio.file.OpenOption;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * Created by wangsm on 2018/5/30.
 */
public class ExecutorCase {



    private static Executor executor = Executors.newFixedThreadPool(10);




    public static void main(String[] args) {


        try {
            Selector selector = Selector.open();

//            FileChannel fileChannel = FileChannel.open("", ExtendedOpenOption.NOSHARE_DELETE)



        } catch (IOException e) {
            e.printStackTrace();
        }


        for (int i = 0; i < 20; i++) {

            executor.execute(new Task());

        }




    }


    static class Task implements Runnable {
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }

}
