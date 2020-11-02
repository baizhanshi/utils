package com.rambo.designMethod.proxy.jdk;

import com.rambo.designMethod.proxy.BuyHouse;
import com.rambo.designMethod.proxy.BuyHouseImpl;

/**
 * 动态代理测试类,依赖于接口
 * 
 * @author ：baizhansi
 * @date ：Created in 2020/10/27 17:49
 */
public class DynamicProxyTest {
    public static void main(String[] args) {

        BuyHouse buyHouse = (BuyHouse) new DynamicProxyHandler().newProxyInstance(new BuyHouseImpl());
        System.out.println(buyHouse.getClass().getName());//$proxy0 $代表自动生成的
        buyHouse.buyHouse();

    }
}
