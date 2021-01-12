package com.rambo.lock;

/**
 * 死锁
 * @author ：baizhansi
 * @date ：Created in 2020/12/30 15:39
 */
public class DeadLock {
    public static final String LOCK1 = "lock1";
    public static final String LOCK2 = "lock2";

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("thread1 trying to get the lock1");
            synchronized (LOCK1) {
                System.out.println("thread1 get the lock1");
                try {
                    Thread.sleep(100);
                } catch (Exception e) {

                }
                System.out.println("thread1 trying to get the lock2");
                synchronized (LOCK2) {
                    System.out.println("thread1 get the lock2");
                }
            }
        }).start();

        new Thread(() -> {
            System.out.println("thread2 trying to get the lock2");
            synchronized (LOCK2) {
                System.out.println("thread1 get the lock2");
                try {
                    Thread.sleep(100);
                } catch (Exception e) {

                }
                System.out.println("thread2 trying to get the lock1");
                synchronized (LOCK1) {
                    System.out.println("thread2 get the lock1");
                }
            }
        }).start();

    }
}
