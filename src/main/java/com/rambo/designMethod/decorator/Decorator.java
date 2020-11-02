package com.rambo.designMethod.decorator;

/**
 * 装饰类
 * @author ：baizhansi
 * @date ：Created in 2020/10/27 10:54
 */
public class Decorator implements ILoginService {

    private ILoginService iLoginService;

    public Decorator(ILoginService iLoginService) {
        this.iLoginService = iLoginService;
    }

    @Override
    public void login(String userName) {
        iLoginService.login(userName);
    }
}
