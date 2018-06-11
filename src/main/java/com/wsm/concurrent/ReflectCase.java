package com.wsm.concurrent;

import java.lang.reflect.Method;

/**
 * Created by wangsm on 2018/6/8.
 */
public class ReflectCase {


    public static void main(String[] args) throws Exception {


        Proxy target = new Proxy();

        Method method = Proxy.class.getDeclaredMethod("run");
        method.invoke(target);


    }


    static class Proxy {
        public void run() {
            System.out.println("run");
        }
    }

}
