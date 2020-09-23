package com.rambo.Proxy.cglibProxy;

/**
 * CGLib 代理
 * @author ：baizhanshi
 * @date ：Created in 2020/6/8 17:30
 */
public class MainForCGLIB {

    public static void main(String[] args) {
        RealSubject subject = (RealSubject) new ProxySubjectForCGLIB().getProxy(RealSubject.class);
        subject.sayHello();
    }
}
