package com.rambo.threadUtil;

/**
 * InheritableThreadLocal 子线程共享主线程数据
 * @author ：baizhanshi
 * @date ：Created in 2020/8/13 15:42
 */
public class ThreadLocalTest {

    //(1)创建ThreadLocal变量
    public static ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        //在main线程中添加main线程的本地变量
        threadLocal.set("mainVal");
        //新创建一个子线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("子线程中的本地变量值:" + threadLocal.get());
            }
        });
        thread.start();
        //输出main线程中的本地变量值
        System.out.println("mainx线程中的本地变量值:" + threadLocal.get());
    }
}
