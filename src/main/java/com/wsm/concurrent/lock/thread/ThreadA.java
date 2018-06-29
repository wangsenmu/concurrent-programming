package com.wsm.concurrent.lock.thread;

/**
 * Created by wangsm on 2018/6/15.
 */
public class ThreadA extends Thread {


    @Override
    public void run() {
        System.out.println("I'm Thread A ");
    }
}
