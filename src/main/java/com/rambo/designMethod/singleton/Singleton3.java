package com.rambo.designMethod.singleton;

/**
 * 匿名内部类的写法 比较好
 * @author ：za-baizhanshi
 * @date ：Created in 2020/10/23 14:50
 */
public class Singleton3 {

    private Singleton3() {
    }

    private static class singletonFactory {
        private static Singleton3 singleton3 = new Singleton3();
    }

    public static Singleton3 getInstance() {
        return singletonFactory.singleton3;
    }
}
