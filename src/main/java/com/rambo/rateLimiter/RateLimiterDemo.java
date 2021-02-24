package com.rambo.rateLimiter;

import com.google.common.util.concurrent.RateLimiter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 限流措施(令牌桶算法)
 * 
 * @author ：baizhanshi
 * @date ：Created in 2019/9/17 10:28
 */
public class RateLimiterDemo {
    public static void main(String[] args) {
        //线程池
        ExecutorService exec = Executors.newCachedThreadPool();
        //速率是每秒只有3个许可
        final RateLimiter rateLimiter = RateLimiter.create(3.0);

        //        for (int i = 0; i < 50; i++) {
        //            final int no = i;
        //            Runnable runnable = new Runnable() {
        //                @Override
        //                public void run() {
        //                    try {
        //                        //获取许可 限流 每秒只能执行三个
        //                        rateLimiter.acquire();
        //                        System.out.println("Accessing: " + no + ",time:"
        //                                + new SimpleDateFormat("yy-MM-dd HH:mm:ss").format(new Date()));
        //
        //                    } catch (Exception e) {
        //                        e.printStackTrace();
        //                    }
        //
        //                }
        //            };
        //            //执行线程
        //            exec.execute(runnable);
        //        }
        //        //退出线程池
        //        exec.shutdown();

        for (int i = 0; i < 50; i++) {
            final int no = i;
            new Thread(() -> {
                try {
                    //获取许可 限流 每秒只能执行三个,rateLimiter.acquire()获取令牌桶时间
                    rateLimiter.acquire();
                    System.out.println(
                            "Accessing: " + no + ",time:" + new SimpleDateFormat("yy-MM-dd HH:mm:ss").format(new Date())
                                    + ",wait time:" + rateLimiter.acquire());

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
