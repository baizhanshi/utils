package com.rambo.Proxy.cglibProxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author ：tpa-baizhanshi
 * @date ：Created in 2020/6/8 17:28
 */
public class ProxySubjectForCGLIB implements MethodInterceptor {
    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz) {
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        //用于创建无参的目标对象代理类，
        // 对于有参构造器则调用Enhancer.create(Class[] argumentTypes, Object[] arguments)，
        // 第一个参数表示参数类型，第二个参数表示参数的值。
        return enhancer.create();
    }

    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("start--->");
        Object result = methodProxy.invokeSuper(object, args);
        System.out.println("end--->");
        return result;
    }
}
