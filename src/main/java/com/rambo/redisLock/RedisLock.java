package com.rambo.redisLock;

import java.util.concurrent.TimeUnit;

/**
 * redis分布式锁 加锁和解锁归于一体化
 *
 * @author ：baizhanshi
 * @date ：Created in 2020/6/9 16:38
 */
public interface RedisLock {

    //加锁操作
    boolean tryLock(String key, long timeout, TimeUnit unit);

    //解锁操作
    void releaseLock(String key);
}
