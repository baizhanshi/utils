package com.rambo.designMethod.proxy;

/**
 * 静态代理
 * @author ：baizhansi
 * @date ：Created in 2020/10/27 17:42
 */
public class BuyHouseProxy implements BuyHouse {

    private BuyHouse buyHouse;

    public BuyHouseProxy(final BuyHouse buyHouse) {
        this.buyHouse = buyHouse;
    }

    @Override
    public void buyHouse() {
        System.out.println("买房前准备");
        buyHouse.buyHouse();
        System.out.println("买房后装修");

    }
}
