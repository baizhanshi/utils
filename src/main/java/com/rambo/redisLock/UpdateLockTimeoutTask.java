package com.rambo.redisLock;

import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author ：baizhanshi
 * @date ：Created in 2020/6/9 16:58
 */
public class UpdateLockTimeoutTask implements Runnable {

    private String uuid;
    private StringRedisTemplate stringRedisTemplate;

    public UpdateLockTimeoutTask(String uuid, StringRedisTemplate stringRedisTemplate) {
        this.uuid = uuid;
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public void run() {
        //以uuid为key，当前线程id为value保存到Redis中
        stringRedisTemplate.opsForValue().set(uuid, String.valueOf(Thread.currentThread().getId()));
        //定义更新锁的过期时间
        while (true) {
            stringRedisTemplate.expire(uuid, 30, TimeUnit.SECONDS);
            try {
                //每隔10秒执行一次
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
