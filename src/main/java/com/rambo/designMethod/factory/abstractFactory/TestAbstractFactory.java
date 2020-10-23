package com.rambo.designMethod.factory.abstractFactory;

/**
 * 抽象工厂测试类（子类中相同的方法进行分组）
 * @author ：za-baizhanshi
 * @date ：Created in 2020/10/23 18:19
 */
public class TestAbstractFactory {
    public static void main(String[] args) {
        IFactory factoryA = new LowEndFactory();
        factoryA.createMask().show();
        factoryA.createSuit().showSuit();
        IFactory factoryB = new HighEndFactory();
        factoryB.createMask().show();
        factoryB.createSuit().showSuit();
    }
}
