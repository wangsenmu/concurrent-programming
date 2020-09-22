package com.wsm.concurrent.lock.redis.lock2;

import com.alibaba.fastjson.JSON;

/**
 * @author wangsenmu
 * @date 2020-9-16 14:50
 */
public class Util {

    public static String beanToJson(Object o) {
        return JSON.toJSONString(o);
    }

    //parse an object from
    public static <T> T jsonToBean(String json, Class<T> cls) {
        return JSON.parseObject(json, cls);
    }
}