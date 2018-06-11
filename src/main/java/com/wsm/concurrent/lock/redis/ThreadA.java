package com.wsm.concurrent.lock.redis;

/**
 * Created by wangsm on 2018/6/11.
 */
public class ThreadA extends Thread {
    private Service service;

    public ThreadA(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        service.seckill();
    }
}
