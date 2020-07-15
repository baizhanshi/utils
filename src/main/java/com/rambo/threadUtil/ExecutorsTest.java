package com.rambo.threadUtil;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

/**
 * 一个线程池中的线程异常了，那么线程池会怎么处理这个线程?答案：有时候抛出堆栈异常，有时候不是比如，submit方式没有get的时候
 * 线程池中线程抛出异常不影响其他的线程继续执行的
 * 当线程池中一个线程异常了会被从线程池中移除的
 *
 * @author ：tpa-baizhanshi
 * @date ：Created in 2020/6/11 17:14
 */
public class ExecutorsTest {

    public static void main(String[] args) throws Exception {
        ThreadPoolTaskExecutor executor = buildPoolTaskExecutor();
        executor.execute(() -> sayHi("execute"));
        TimeUnit.MICROSECONDS.sleep(10);
        Future<?> future = executor.submit(() -> sayHi("submit"));
        try {
            future.get();//如果不做这一步，这种方式是不会抛出异常的。
        } catch (Exception e) {
            e.printStackTrace();
        }
        Executors.newFixedThreadPool(3);

    }


    private static void sayHi(String name) {
        String printString = "thread name =" + Thread.currentThread().getName() + " 执行方式-===" + name;
        System.out.println(printString);
        if (name.equals("execute")) {
            throw new RuntimeException("抛出异常：" + printString);
        }

    }

    public static ThreadPoolTaskExecutor buildPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(1000);
        executor.setKeepAliveSeconds(30);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());//重试添加当前的任务，他会自动重复调用execute()方法
        executor.initialize();
        return executor;
    }
}
