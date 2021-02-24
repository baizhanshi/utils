package com.rambo.lock.alternate;

import java.util.concurrent.locks.LockSupport;

/**
 * 注意顺序 唤醒-阻塞---》阻塞-唤醒
 * 
 * @author ：baizhanshi
 * @date ：Created in 2021/1/15 10:19
 */
public class TestLockSupport {
    static Thread t1 = null;
    static Thread t2 = null;

    public static void main(String[] args) {
        char[] aI = { '1', '2', '3', '4', '5' };
        char[] aC = { 'A', 'B', 'C', 'D', 'E' };

        t1 = new Thread(() -> {
            for (char i : aI) {
                System.out.print(i);
                LockSupport.unpark(t2);//唤醒t2
                LockSupport.park();//阻塞t1
            }
        });

        t2 = new Thread(() -> {
            for (char c : aC) {
                LockSupport.park();//阻塞t2
                System.out.print(c);
                LockSupport.unpark(t1);//唤醒t1
            }
        });
        t1.start();
        t2.start();
    }
}
