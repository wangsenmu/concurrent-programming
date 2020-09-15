package com.wsm.concurrent.executor;

import lombok.extern.slf4j.Slf4j;
import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Visibility {




    public static boolean a = true;

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {

//            log.info("123");
            System.out.println("I'm in ");
            while (a) {
//            System.out.println("I'm in ");

                /*try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
//            log.info("123");
//                System.out.println(1);
            }
//            log.info("456");
            System.out.println("I'm out");
        });

        Thread.sleep(100);
        a = false;
    }


}
