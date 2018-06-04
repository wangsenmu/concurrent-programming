package com.wsm.concurrent;

/**
 * Created by wangsm on 2018/6/1.
 */
public class Case {

    public volatile int n;

    public void add() {
        n++;
    }


    public synchronized void add1() {

    }

    public int a = 1;

    public boolean compareAdnSwapInt(int b) {
        if (a == 1) {
            a = b;
            return true;
        }
        return false;

    }

}
