package com.rambo.threadUtil;

import java.util.concurrent.CyclicBarrier;

/**
 * @author ：baizhansi
 * @date ：Created in 2020/12/2 10:37
 */
public class CyclicbarrierTest {
    public static final int INIT_NUM = 5;

    public static void main(String[] args) {
        CyclicBarrier cyc = new CyclicBarrier(INIT_NUM, new Runnable() {
            @Override
            public void run() {
                System.out.println("init cyclicBarrier----");
            }
        });

        for (int i = 0; i < INIT_NUM; i++) {
            new sampleCyclic(cyc).start();
        }
    }

    private static class sampleCyclic extends Thread {
        CyclicBarrier barrier;

        public sampleCyclic(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            System.out.println("start=====");
            try {
                barrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("id" + Thread.currentThread().getId() + "working----");
        }
    }

}
