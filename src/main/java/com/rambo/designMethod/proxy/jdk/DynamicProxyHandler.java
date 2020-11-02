package com.rambo.designMethod.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态处理器
 * 
 * @author ：baizhansi
 * @date ：Created in 2020/10/27 17:48
 */
public class DynamicProxyHandler implements InvocationHandler {

    private Object object;

    public Object newProxyInstance(Object object) {
        this.object = object;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(), object.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("买房前准备");
        Object result = method.invoke(object, args);
        System.out.println("买房后装修");
        return result;
    }
}
