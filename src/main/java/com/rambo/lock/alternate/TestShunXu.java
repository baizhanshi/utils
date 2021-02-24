package com.rambo.lock.alternate;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程顺序输出1-100
 *
 * @author ：baizhanshi
 * @date ：Created in 2021/1/29 17:17
 */
public class TestShunXu {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition1 = lock.newCondition();//其实就是一个队列
        Condition condition2 = lock.newCondition();
        new Thread(() -> {
            try {
                lock.lock();
                for (int i = 1; i <= 100; i++) {
                    if (i % 2 == 0) {
                        System.out.print(i + " ");
                        condition2.signal();//唤醒2
                        condition1.await();//阻塞1
                    }
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
                for (int i = 1; i <= 100; i++) {
                    if (i % 2 == 1) {
                        System.out.print(i + " ");
                        condition1.signal();//唤醒1
                        condition2.await();//阻塞2
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();
    }
}
