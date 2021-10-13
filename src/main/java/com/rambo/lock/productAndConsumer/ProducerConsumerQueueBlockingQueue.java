package com.rambo.lock.productAndConsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author ：baizhanshi
 * @date ：Created in 2021/10/13 17:22
 */
public class ProducerConsumerQueueBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(100);
        Producer p = new Producer(queue);
        Consumer c1 = new Consumer(queue);
        Consumer c2 = new Consumer(queue);

        Thread producer = new Thread(p);
        producer.setName("生产者线程");
        Thread consumer1 = new Thread(c1);
        consumer1.setName("消费者1");
        Thread consumer2 = new Thread(c2);
        consumer2.setName("消费者2");

        producer.start();
        consumer1.start();
        consumer2.start();
    }
}

