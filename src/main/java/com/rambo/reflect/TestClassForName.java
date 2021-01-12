package com.rambo.reflect;

/**
 * 测试Class.forName()方式
 * 
 * @author ：baizhanshi
 * @date ：Created in 2020/6/22 14:54
 *       Class.forName加载类时将类进了初始化，而ClassLoader的loadClass并没有对类进行初始化，只是把类加载到了虚拟机中。
 */
public class TestClassForName {

    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("com.rambo.reflect.ClassForName");
        System.out.println("#########-------------Class.forName结束符------------##########");

        Class<?> aClass1 = ClassLoader.getSystemClassLoader().loadClass("com.rambo.reflect.ClassForName");
        System.out.println("#########-------------ClassLoader结束符------------##########");//没有初始化数据
    }
}

class Singleton {
    //初始化构造防止被实例化
    private Singleton() {
    }

    private static class singletonFactory {
        private static Singleton instance = new Singleton();
    }

    public static Singleton getInstance(){
        return singletonFactory.instance;
    }
}
