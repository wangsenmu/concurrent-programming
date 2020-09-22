package com.wsm.concurrent.lock.redis.lock2.annotation;

import java.lang.annotation.*;

/**
 * @author wangsenmu
 * @date 2020-9-16 14:28
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CacheLock {


    //redis 锁key的前缀
    String lockedPrefix() default "";

    //轮询锁的时间
    long timeOut() default 2000;

    //key在redis里存在的时间，1000S
    int expireTime() default 1000;
}
