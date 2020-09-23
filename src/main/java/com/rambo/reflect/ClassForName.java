package com.rambo.reflect;

/**
 * @author ：baizhanshi
 * @date ：Created in 2020/6/22 14:54
 */
public class ClassForName {
    //静态代码块
    static {
        System.out.println("执行了静态代码块");
    }

    //静态变量
    private static String staticFiled = staticMethod();

    //赋值静态变量的静态方法
    public static String staticMethod() {
        System.out.println("执行了静态方法");
        return "给静态字段赋值了";
    }
}
