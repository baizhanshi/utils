package com.rambo.lock.alternate;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * reentrantLock 可重入锁 signal await
 * 
 * @author ：baizhanshi
 * @date ：Created in 2021/1/15 10:30
 */
public class TestReentrantLock {
    public static void main(String[] args) {
        char[] aI = { '1', '2', '3', '4', '5' };
        char[] aC = { 'A', 'B', 'C', 'D', 'E' };
        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();//其实就是一个队列
        Condition condition2 = lock.newCondition();
        new Thread(() -> {
            try {
                lock.lock();
                for (char i : aI) {
                    System.out.print(i);
                    condition2.signal();//唤醒2
                    condition1.await();//阻塞1
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

        new Thread(() -> {
            try {
                lock.lock();
                for (char c : aC) {
                    System.out.print(c);
                    condition1.signal();//唤醒1
                    condition2.await();//阻塞2
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

    }
}
