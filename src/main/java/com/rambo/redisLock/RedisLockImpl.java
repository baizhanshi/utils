package com.rambo.redisLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 关键点：
 * 1.原子命令加锁setIfAbsent
 * 2.设置值的时候唯一性uuid，保证锁的唯一
 * 3.threadLocal.get().equals(uuid) 保证设置的和取出来的唯一才可以释放锁，就是加锁和解锁归一
 *
 * @author ：tpa-baizhanshi
 * @date ：Created in 2020/6/9 16:38
 */
@Service
public class RedisLockImpl implements RedisLock {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //实现加锁和解锁的归一化
    private ThreadLocal<String> threadLocal = new ThreadLocal<>();
    //解决了可重入性问题（同一个线程，能够多次获取同一把锁）
    private ThreadLocal<Integer> threadLocalInteger = new ThreadLocal<>();

    @Override
    public boolean tryLock(String key, long timeout, TimeUnit unit) {
        Boolean isLocked = false;
        if (threadLocal.get() == null) {
            String uuid = UUID.randomUUID().toString();
            threadLocal.set(uuid);
            //原子命令加锁 todo暂时版本不支持注掉
//            isLocked = stringRedisTemplate.opsForValue().setIfAbsent(key, uuid, timeout, unit);
            //如果获取锁失败，则自旋获取锁，直到成功
            if (!isLocked) {
                for (; ; ) {
//                    isLocked = stringRedisTemplate.opsForValue().setIfAbsent(key, uuid, timeout, unit);
                    if (isLocked) {
                        break;
                    }
                }
            }
            //防止业务代码没有执行完，锁失效了，启动新线程来执行定时任务，更新锁过期时间
            new Thread(new UpdateLockTimeoutTask(uuid, stringRedisTemplate)).start();
        } else {
            isLocked = true;
        }
        //加锁成功后将计数器加1
        if (isLocked) {
            Integer count = threadLocalInteger.get() == null ? 0 : threadLocalInteger.get();
            threadLocalInteger.set(count++);
        }
        return isLocked;
    }

    @Override
    public void releaseLock(String key) {
        //当前线程中绑定的uuid与Redis中的uuid相同时，再执行删除锁的操作
        String uuid = stringRedisTemplate.opsForValue().get(key);
        if (threadLocal.get().equals(uuid)) {
            Integer count = threadLocalInteger.get();
            //计数器减为0时释放锁
            if (count == null || --count <= 0) {
                stringRedisTemplate.delete(key);
                //获取更新锁超时时间的线程并中断
                String threadId = stringRedisTemplate.opsForValue().get(uuid);
                Thread updateLockTimeoutThread = ThreadUtils.getThreadByThreadId(Long.valueOf(threadId));
                if (updateLockTimeoutThread != null) {
                    //中断更新锁超时时间的线程
                    updateLockTimeoutThread.interrupt();
                    stringRedisTemplate.delete(uuid);
                }
            }
        }
    }
}
