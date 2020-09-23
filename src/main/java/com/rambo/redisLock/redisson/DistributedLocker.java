package com.rambo.redisLock.redisson;

import org.redisson.api.RLock;

import java.util.concurrent.TimeUnit;

/**
 * redisson分布式锁接口
 * 
 * @author ：baizhanshi
 * @date ：Created in 2020/9/15 15:30
 */
public interface DistributedLocker {

    /**
     * 加锁
     * 
     * @param lockKey
     * @return
     */
    RLock lock(String lockKey);

    /**
     * 带超时的锁
     * 
     * @param lockKey
     * @param timeout
     * @return
     */
    RLock lock(String lockKey, int timeout);

    /**
     * 带超时的锁
     *
     * @param lockKey
     * @param unit
     * @param timeout
     * @return
     */
    RLock lock(String lockKey, TimeUnit unit, int timeout);

    /**
     * 尝试获取锁
     * 
     * @param lockKey
     * @param unit
     * @param waitTime
     * @param leaseTime
     * @return
     */
    boolean tryLock(String lockKey, TimeUnit unit, int waitTime, int leaseTime);

    /**
     * 释放锁
     * 
     * @param lockKey
     */
    void unlock(String lockKey);

    /**
     * 释放锁
     * 
     * @param lock
     */
    void unlock(RLock lock);
}
