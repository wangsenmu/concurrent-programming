package com.wsm.concurrent.lock.redis.lock2;

import com.wsm.concurrent.lock.redis.lock2.annotation.CacheLock;
import com.wsm.concurrent.lock.redis.lock2.annotation.LockedObject;

/**
 * @author wangsenmu
 * @date 2020-9-16 14:54
 */
public interface SeckillInterface {

    @CacheLock(lockedPrefix = "TEST_PREFIX")
    void secKill(String arg1, @LockedObject Long arg2);

}