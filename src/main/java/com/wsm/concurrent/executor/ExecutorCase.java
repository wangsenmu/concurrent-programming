package com.wsm.concurrent.executor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * Created by wangsm on 2018/5/30.
 */
public class ExecutorCase {



    private static Executor executor = Executors.newScheduledThreadPool(10);




    public static void main(String[] args) {



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
