package com.wsm.concurrent.lock.redis.lock2;

/**
 * @author wangsenmu
 * @date 2020-9-16 14:47
 */
public class CacheLockException extends Throwable {
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public CacheLockException(String msg) {
        this.msg = msg;
    }

    public CacheLockException() {
    }

}
