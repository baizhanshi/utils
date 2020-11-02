package com.rambo.designMethod.decorator;

/**
 * 具体装饰类
 * 
 * @author ：baizhansi
 * @date ：Created in 2020/10/27 10:56
 */
public class WechatLoginDecorator extends Decorator {

    public WechatLoginDecorator(ILoginService iLoginService) {
        super(iLoginService);
    }

    @Override
    public void login(String userName) {
        System.out.println("我是具体登录信息：" + userName);
    }
}
