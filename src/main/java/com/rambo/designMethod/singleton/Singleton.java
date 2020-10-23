package com.rambo.designMethod.singleton;

/**
 * 饿汉式单例模式(线程安全的) 用不用都会创建一个单子，占用内存空间
 * 
 * @author ：za-baizhanshi
 * @date ：Created in 2020/10/23 14:41
 */
public class Singleton {

    private Singleton() {
    }

    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }

}
