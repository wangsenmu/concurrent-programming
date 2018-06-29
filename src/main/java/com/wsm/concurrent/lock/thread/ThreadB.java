package com.wsm.concurrent.lock.thread;

/**
 * Created by wangsm on 2018/6/15.
 */
public class ThreadB extends  Thread{

    @Override
    public void run() {
        System.out.println("I'm ThreadB");
    }
}
