package com.rambo.lock.alternate;

/**
 * synchronized+notify+wait 最原始的写法
 * 
 * @author ：baizhanshi
 * @date ：Created in 2021/1/15 10:09
 */
public class TestSynWaitNotify {
    private static Object lock = new Object();

    public static void main(String[] args) {
        char[] aI = { '1', '2', '3', '4', '5' };
        char[] aC = { 'A', 'B', 'C', 'D', 'E' };

        new Thread(() -> {
            synchronized (lock) {
                for (char i : aI) {
                    System.out.print(i);
                    try {
                        lock.notify();//唤醒锁
                        lock.wait();//锁等待
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();//如果没有，会出现乱序，或者整个流程无法结束
            }
        }).start();

        new Thread(() -> {
            synchronized (lock) {
                for (char c : aC) {
                    System.out.print(c);
                    try {
                        lock.notify();
                        lock.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }).start();
    }
}
