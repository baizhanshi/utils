package com.rambo.designMethod.factory.abstractFactory;

/**
 * @author ：za-baizhanshi
 * @date ：Created in 2020/10/23 18:15
 */
public class LowEndProtectiveSuit implements IProtectiveSuit {
    @Override
    public void showSuit() {
        System.out.println("我是低端防护服");
    }
}
