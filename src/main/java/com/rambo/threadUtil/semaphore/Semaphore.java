package com.rambo.threadUtil.semaphore;

/**
 * 应用场景：多个线程使用数量有限的资源。
 * Semaphore是一种基于计数的信号量。它可以设定一个阀值，基于此，多个线程竞争获取许可信号，做自己的申请后归还，超过阀值后，线程申请许可信号将会被阻塞。
 * Semaphore可以用来构建一些对象池，资源池之类的，比如数据库连接池，
 * 我们也可以创建计数为1的Semaphore，将其作为一种类似互斥锁的机制，这也叫二元信号量，表示两种互斥状态。
 * 
 * @author ：baizhanshi
 * @date ：Created in 2021/2/4 14:49
 */
public class Semaphore implements java.io.Serializable {

    // 最多支持N个资源访问
    public Semaphore(int permits) {

    }

    // 获取可用的资源，
    // 如果可用, 信号量内部的资源个数减掉1，
    // 如果没有可用资源线程会阻塞在该方法中，不能结束该方法，不能返回，直到有可用的资源为止
    public void acquire() throws InterruptedException {

    }

    // 当前可用的资源个数， permits - availablePermits() = 正在使用的资源个数
    public int availablePermits() {
        return 0;
    }

    // 释放资源，释放后信号量内部的资源个数会增加1
    // 如果有被阻塞的线程，释放后会唤醒一个线程去获取资源
    // acquire() 和 release()要成对使用，一般release()放在finally代码块中
    public void release() {

    }
}
