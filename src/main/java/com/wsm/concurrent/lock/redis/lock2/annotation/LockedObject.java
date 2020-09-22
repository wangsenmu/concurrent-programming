package com.wsm.concurrent.lock.redis.lock2.annotation;

import java.lang.annotation.*;

/**
 * @author wangsenmu
 * @date 2020-9-16 14:31
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LockedObject {
}
