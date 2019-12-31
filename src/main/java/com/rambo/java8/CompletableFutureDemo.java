package com.rambo.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 异步处理逻辑 Created by baizhanshi on 2019/5/31.
 */
public class CompletableFutureDemo {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        // 结果集
        List<String> list = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Integer> taskList = Arrays.asList(2, 1, 3, 4, 5, 6, 7, 8, 9, 10);
        // 全流式处理转换成CompletableFuture[]+组装成一个无返回值CompletableFuture，join等待执行完毕。返回结果whenComplete获取
        CompletableFuture[] cfs = taskList.stream()
                .map(integer -> CompletableFuture.supplyAsync(() -> calc(integer), executorService)
                        .thenApply(h -> Integer.toString(h)).whenComplete((s, e) -> {
                            System.out.println("任务" + s + "完成!result=" + s + "，异常 e=" + e);
                            list.add(s);
                        }))
                .toArray(CompletableFuture[]::new);
        //thenApply integer->string
        taskList.stream().parallel();
        taskList.parallelStream();
        // 封装后无返回值，必须自己whenComplete()获取
        CompletableFuture.allOf(cfs).join();
        System.out.println("list=" + list + ",耗时=" + (System.currentTimeMillis() - start));
        executorService.shutdown();//关闭多线程
    }

    public static int calc(Integer i) {
        try {
            if (i == 1) {
                Thread.sleep(300);//任务1耗时3秒
            } else if (i == 5) {
                Thread.sleep(500);//任务5耗时5秒
            } else {
                Thread.sleep(100);//其它任务耗时1秒
            }
            System.out.println("task线程：" + Thread.currentThread().getName() + "任务i=" + i + ",完成！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return i;
    }
}
