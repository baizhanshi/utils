package com.rambo.Proxy.jdkProxy;

/**
 * JDK 动态代理
 *
 * @author ：tpa-baizhanshi
 * @date ：Created in 2020/6/8 17:24
 */
public class TestClient {
    public static void main(String[] args) {
        LogHandler logHandler = new LogHandler();

        UserManager userManager = (UserManager) logHandler.newProxyInstance(new UserManagerImpl());
        userManager.addUser("123", "456");
    }
}
