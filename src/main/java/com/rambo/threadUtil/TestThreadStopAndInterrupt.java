package com.rambo.threadUtil;

import java.util.concurrent.TimeUnit;

/**
 *
 * stop就相当于强制关闭，interrupt相当于优雅关闭。
 * stop方法不建议使用，它可能会导致线程安全问题
   interrupt方法不会出现强制中止的情况，会抛出一个异常，线程是安全的
 *
 *
 * @author ：baizhanshi
 * @date ：Created in 2020/7/16 17:50
 */
public class TestThreadStopAndInterrupt {
        public static void main(String[] args) {
            Object o = new Object();
            Thread t = new Thread(() -> {
                synchronized (o) {
                    try {
                        o.wait();
                        //TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        //线程被中断时，可以在该异常中执行清尾操作。
                        System.out.println("interrupt 方式线程被中断时，可以在该异常中执行清尾操作。");
                    }
                }
            });

            t.start();
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //中断线程t
//            t.stop();
            t.interrupt();
        }
    }
