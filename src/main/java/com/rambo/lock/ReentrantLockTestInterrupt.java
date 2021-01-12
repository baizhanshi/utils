package com.rambo.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 中断锁
 * @author ：baizhansi
 * @date ：Created in 2020/11/23 17:50
 */
public class ReentrantLockTestInterrupt {
    public static Lock lock  = new ReentrantLock();
    public static Lock lock1 = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new threadDemo(lock, lock1));
        Thread thread1 = new Thread(new threadDemo(lock, lock1));
        thread.start();
        thread1.start();
        thread.interrupt();
    }

}

class threadDemo implements Runnable {
    Lock firstLock;
    Lock secondLock;

    public threadDemo(Lock firstLock, Lock secondLock) {
        this.firstLock = firstLock;
        this.secondLock = secondLock;
    }

    @Override
    public void run() {
        try {
            firstLock.lockInterruptibly();
            TimeUnit.MILLISECONDS.sleep(50);
            secondLock.lockInterruptibly();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            firstLock.unlock();
            secondLock.unlock();
            System.out.println(Thread.currentThread().getName() + "获取到了资源，正常结束");
        }
    }
}
