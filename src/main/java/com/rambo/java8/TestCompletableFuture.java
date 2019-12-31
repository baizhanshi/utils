package com.rambo.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * Created by baizhanshi on 2019/5/31.
 */
public class TestCompletableFuture {
    public static void main(String[] args) throws Exception {
        //无返回值runAsync
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
            System.out.println("run end ...");
        });
        future1.get();

        //有返回值supplyAsync
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            return "hello world";
        });
        System.out.println(future.get()); //阻塞的获取结果  ''helllo world"

        //whenComplete
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
            }
            if (new Random().nextInt() % 2 >= 0) {
                int i = 12 / 0;
            }
            System.out.println("run end ...");
        });

        future2.whenComplete(new BiConsumer<Void, Throwable>() {
            @Override
            public void accept(Void t, Throwable action) {
                System.out.println("执行完成！");
            }

        });

        //thenApply 第二个线程依赖第一个线程的执行结果
        ExecutorService executor = Executors.newFixedThreadPool(3);

        CompletableFuture cf = CompletableFuture.completedFuture("message").thenApply(e -> {
            return e.toUpperCase();
        });
        System.out.println(cf.get(10, TimeUnit.SECONDS));
        executor.shutdown();

        CompletableFuture<Long> future3 = CompletableFuture.supplyAsync(new Supplier<Long>() {
            @Override
            public Long get() {
                long result = new Random().nextInt(100);
                System.out.println("result1=" + result);
                return result;
            }
        }).thenApply(new Function<Long, Long>() {
            @Override
            public Long apply(Long t) {
                long result = t * 5;
                System.out.println("result2=" + result);
                return result;
            }
        });
        System.out.println(future.get());

        //thenAccept同步 thenAcceptAsync 异步
        StringBuffer sf = new StringBuffer("my ");
        CompletableFuture.completedFuture("run message").thenAccept(s -> sf.append(s));

        System.out.println(sf.toString());

        StringBuffer sf1 = new StringBuffer("my async ");
        CompletableFuture cf1 = CompletableFuture.completedFuture("run message").thenAcceptAsync(s -> sf1.append(s));
        cf1.join();

        System.out.println("异步消费迁移结果：" + sf1.toString());

        CompletableFuture<Void> future4 = CompletableFuture.supplyAsync(() -> {
            return new Random().nextInt(10);
        }).thenAccept(integer -> {
            System.out.println("随机获取数据：" + integer);
        });
        future4.get();

        //thenCombine 会把 两个 CompletionStage 的任务都执行完成后，把两个任务的结果一块交给 thenCombine 来处理。
        CompletableFuture<String> future5 = CompletableFuture.supplyAsync(() -> {
            return "hello1";
        });
        CompletableFuture<String> future6 = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                return "hello2";
            }
        });
        //上下两种写法一样
        CompletableFuture<String> result1 = future5.thenCombine(future6, new BiFunction<String, String, String>() {
            @Override
            public String apply(String t, String u) {
                return t + " " + u;
            }
        });
        System.out.println(result1.get());

        //当几个阶段中的一个完成，创建一个完成的阶段
        StringBuilder result = new StringBuilder();
        List<String> messages = Arrays.asList("a", "b", "c");
        List<CompletableFuture> futures = messages.stream()
                .map(msg -> CompletableFuture.completedFuture(msg).thenApply(str -> {
                    return str.toUpperCase();
                })).collect(Collectors.toList());

        CompletableFuture.anyOf(futures.toArray(new CompletableFuture[futures.size()])).whenComplete((res, th) -> {
            if (th == null) {
                result.append(res);
            }
        });
        System.out.println("任何一个完成返回结果：" + result);

        //当几个阶段中的都完成，创建一个完成的阶段
        StringBuilder result2 = new StringBuilder();
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()])).whenComplete((v, th) -> {
            futures.forEach(cf2 -> result2.append(cf2.getNow(null)));
        });
        System.out.println("所有结果完成返回结果：" + result2);

    }

}
