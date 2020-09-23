package com.rambo.threadUtil.future;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 三个异步任务，耗时最长的最先执行，所以最先进入 list，因此当在循环中获取这个任务结果的时候 get 操作会一直阻塞，即使执行时间为 5s/10s 的任务已经执行完成。（木桶原理）
 * @author ：baizhanshi
 * @date ：Created in 2020/8/17 13:52
 */
public class JDKThreadPoolExecutorTest {
    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        ArrayList<Future<String>> list = new ArrayList<>();
        System.out.println("约几个妹子一起吃个饭吧。");
        Future<String> future_15 = executorService.submit(() -> {
            System.out.println("小红：好的，哥哥。我化妆要2个小时。等一下哦。");
            TimeUnit.SECONDS.sleep(15);
            System.out.println("小红：我2个小时准时化好了，哥哥来接我吧。");
            return "小红化完了。";
        });
        list.add(future_15);
        Future<String> future_5 = executorService.submit(() -> {
            System.out.println("小媛：好的，哥哥。我化妆要30分钟。等一下哦。");
            TimeUnit.SECONDS.sleep(5);
            System.out.println("小媛：我30分钟准时化好了，哥哥来接我吧。");
            return "小媛化完了。";
        });
        list.add(future_5);

        Future<String> future_10 = executorService.submit(() -> {
            System.out.println("小花：好的，哥哥。我化妆要1个小时。等一下哦。");
            TimeUnit.SECONDS.sleep(10);
            System.out.println("小花：我1个小时准时化好了，哥哥来接我吧。");
            return "小花化完了。";
        });
        list.add(future_10);
        TimeUnit.SECONDS.sleep(1);
        System.out.println("都通知完,等着吧。");
        for (Future<String> future : list) {
            System.out.println(future.get()+"我去接她。");
        }
        Thread.currentThread().join();
    }
}
