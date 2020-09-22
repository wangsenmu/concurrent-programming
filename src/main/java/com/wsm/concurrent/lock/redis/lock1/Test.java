package com.wsm.concurrent.lock.redis.lock1;

/**
 * Created by wangsm on 2018/6/11.
 */
public class Test {
    public static void main(String[] args) {
        Service service = new Service();
        for (int i = 0; i < 50; i++) {
            ThreadA threadA = new ThreadA(service);
            threadA.start();
        }
    }
}
