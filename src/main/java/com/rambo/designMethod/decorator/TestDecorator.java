package com.rambo.designMethod.decorator;

/**
 * 装饰类测试
 * @author ：baizhansi
 * @date ：Created in 2020/10/27 11:00
 */
public class TestDecorator {
    public static void main(String[] args) {
        Decorator decorator = new WechatLoginDecorator(new LoginServiceImpl());
        decorator.login("张三");
    }
}
