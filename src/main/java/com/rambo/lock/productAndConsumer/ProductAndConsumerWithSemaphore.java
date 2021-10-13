package com.rambo.lock.productAndConsumer;

import java.util.concurrent.Semaphore;

/**
 * @author ：baizhanshi
 * @date ：Created in 2021/10/13 17:13
 * 使用semaphore信号量实现生产者消费者问题。
 * 生产者消费者问题的本质，其实就是同步和互斥的问题。
 * 同步问题，其实就是一前一后的问题，某个进程或者程序，必须在另一个的前面或者后面执行，他俩不能同时执行，就是这个意思。
 * 互斥问题，即某个资源不能同时被两个进程占用
 */
public class ProductAndConsumerWithSemaphore {
    //比如这是苹果的数量。
    private static Integer count = 0;
    //创建三个信号量
    //这个是生产者许可，最多可以获取10个许可，也就是说最多生产10个苹果。
    final Semaphore provider = new Semaphore(3);
    //这个是消费者许可。一个空盘子。
    final Semaphore consumer = new Semaphore(0);
    //体现互斥的地方：保证生产者和消费者之间的交替进行 所以再设置一个mutex信号量
    final Semaphore mutex = new Semaphore(1);

    public static void main(String[] args) {
        ProductAndConsumerWithSemaphore test = new ProductAndConsumerWithSemaphore();
        new Thread(test.new Producer()).start();
        new Thread(test.new Consumer()).start();
    }

    //acquire()方法尝试获得一个准入的许可。若无法获得，则线程会等待，直到有线程释放一个许可或当前线程被中断.
    //release()方法用于在线程访问资源结束后，释放一个许可。以使其他等待许可的线程可以进行资源访问.
    class Producer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    provider.acquire();//生产者先行，获得许可，因为final Semaphore provider = new Semaphore(10);
                    mutex.acquire();
                    count++;// 生产一个苹果
                    System.out.println(Thread.currentThread().getName() + "生产者生产，目前总共有" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    mutex.release();
                    // acquire与release之间的关系：
                    // 在实现中不包含真正的许可对象，并且Semaphore也不会将许可与线程关联起来，因此在一个线程中获得的许可可以在另一个线程中释放。也就是说acquire与release并没有强制的一对一关系
                    consumer.release();//生产完苹果，消费者获取到了许可。

                }
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                try {
                    consumer.acquire();
                    mutex.acquire();
                    count--;
                    System.out.println(Thread.currentThread().getName()
                            + "消费者消费，目前总共有" + count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    mutex.release();
                    provider.release();
                }
            }
        }
    }
}