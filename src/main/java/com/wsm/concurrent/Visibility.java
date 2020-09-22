package com.wsm.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

/**
 * @author wangsenmu
 * @date 2020-9-11 13:53
 */
public class Visibility {

    public static Logger logger = Logger.getLogger(Visibility.class.getSimpleName());

    private static boolean flag = false;

    public static void main(String[] args) throws InterruptedException {

/*
        CountDownLatch countDownLatch = new CountDownLatch(10);
        countDownLatch.countDown();
        countDownLatch.await();
*/

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            logger.info("I'm in");
            while (!flag) {
//                logger.info("I'm 1");
            }
            logger.info("I'm out");
        });
        Thread.sleep(100);
        flag = true;

    }


}