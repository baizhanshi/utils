package com.rambo.threadUtil.semaphore;

import java.util.concurrent.Semaphore;

/**
 * 信号量
 * @author ：baizhanshi
 * @date ：Created in 2021/2/4 14:45
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <= 10; i++) {
            new Thread(new MyRunnable(semaphore), "第" + i + "个人").start();
        }
    }
}

class MyRunnable implements Runnable {
    private Semaphore semaphore;
    public MyRunnable(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        int availablePermits = semaphore.availablePermits();//当前可用资源个数
        if (availablePermits > 0) {
            System.out.println(name + "无人，可用");
        } else {
            System.out.println(name + "有人，请排队。。。\t?");
        }

        try {
            // 如果没有拿到资源将一直等待，直到有人释放，拿到资源
            semaphore.acquire();//获取可用资源
            System.out.println(name + "轮到我了");
            // 模拟使用时间
            Thread.sleep(1000);
            System.out.println(name + "使用完毕\t?");
        } catch (InterruptedException e) {
        } finally {
            // 使用完释放资源
            semaphore.release();
        }
    }
}