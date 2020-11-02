package com.rambo.designMethod.proxy.cglib;

/**
 * cglib动态代理测试类,依赖于类BuyHouseClass 不用依赖于接口就可以实现动态代理
 * 
 * @author ：baizhansi
 * @date ：Created in 2020/10/27 17:52
 */
public class CglibProxyTest {
    public static void main(String[] args) {

        BuyHouseClass buyHouseClass = (BuyHouseClass) new CglibProxy().getInstance(BuyHouseClass.class);
        buyHouseClass.buyHouse();
    }
}
