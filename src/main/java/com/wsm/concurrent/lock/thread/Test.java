package com.wsm.concurrent.lock.thread;

/**
 * Created by wangsm on 2018/6/15.
 */
public class Test {


    public static void main(String[] args) {

        ThreadA threadA = new Thre`/ adA();
        threadA.start();
        try {
            threadA.wait();
            ThreadB threadB = new ThreadB();
            threadB.sleep(10000l);



        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
