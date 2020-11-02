package com.rambo.designMethod.decorator;

/**
 * @author ：baizhansi
 * @date ：Created in 2020/10/27 10:52
 */
public class LoginServiceImpl implements ILoginService {
    @Override
    public void login(String userName) {
        System.out.println("我是原始的登录接口信息：" + userName);
    }
}
