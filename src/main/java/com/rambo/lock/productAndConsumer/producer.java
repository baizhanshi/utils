package com.rambo.lock.productAndConsumer;


import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * 生产者
 * @author ：baizhanshi
 * @date ：Created in 2021/10/13 17:24
 */
public class Producer implements Runnable {

    private final BlockingQueue<Integer> queue;

    public Producer(BlockingQueue q) {
        this.queue = q;
    }

    @Override
    public void run() {
        try {
            while (true) {
                //模拟耗时1s
                Thread.sleep(1000);
                queue.put(produce());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private int produce() {
        int n = new Random().nextInt(10000);
        System.out.println("Thread: " + Thread.currentThread().getName() + " produce: " + n);
        return n;
    }
}
