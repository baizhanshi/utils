package com.rambo.threadUtil;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author ：tpa-baizhanshi
 * @date ：Created in 2020/4/7 18:16
 */
public class ThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            executor.execute(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                }
            });
        }

        new Thread(()-> System.out.println("创建线程！")).start();
    }
}