package com.wsm.concurrent;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by wangsm on 2018/1/12.
 */
public class ConCurrentHashMapStudy {

    volatile int i = 0;

    public void test(){
        AtomicInteger atomicInteger = new AtomicInteger();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        CopyOnWriteArrayList copyOnWriteArrayList =  new CopyOnWriteArrayList();


    }


}
