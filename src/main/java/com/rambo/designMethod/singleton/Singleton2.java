package com.rambo.designMethod.singleton;

/**
 * 懒汉式单例模式,使用的是延迟加载模式（线程不安全）
 * 
 * @author ：baizhansi
 * @date ：Created in 2020/10/23 14:47
 */
public class Singleton2 {
    private Singleton2() {
    }

    private static Singleton2 singleton2 = null;

    public static Singleton2 getInstance() {
        if (singleton2 == null) {
            singleton2 = new Singleton2();
        }
        return singleton2;
    }

}
