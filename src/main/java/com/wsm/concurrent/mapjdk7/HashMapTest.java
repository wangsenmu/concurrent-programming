package com.wsm.concurrent.mapjdk7;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangsm on 2018/5/31.
 */
public class HashMapTest {


    public static void main(String[] args) {


        Map<String,String> map = new HashMap<String, String>();

        map.put("a","a");
        map.put("b","b");
        map.put("c","c");
        map.put("d","d");

        map.get("a");

    }

}
