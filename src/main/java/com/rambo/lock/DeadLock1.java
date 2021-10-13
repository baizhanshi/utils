package com.rambo.lock;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 死锁
 * 线程池类型是单一线程，但是任务1依赖任务2的执行结果，由于单线程模式，任务1没有执行完，任务2永远得不到执行，就死锁了。
 *
 * @author ：baizhansi
 * @date ：Created in 2021/10/30 15:39
 */
public class DeadLock1 {

    public static void main(String[] args) throws Exception {
        final ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Long> f1 = executorService.submit(new Callable<Long>() {

            @Override
            public Long call() throws Exception {
                System.out.println("start f1");
                Thread.sleep(1000);//延时
                Future<Long> f2 =
                        executorService.submit(new Callable<Long>() {
                            @Override
                            public Long call() throws Exception {
                                System.out.println("start f2");
                                return -1L;
                            }
                        });
                System.out.println("result" + f2.get());
                return -1L;
            }
        });
        System.out.println("result" + f1.get());
        System.out.println("end f1");
    }
}

