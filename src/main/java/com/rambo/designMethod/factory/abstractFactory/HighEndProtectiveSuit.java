package com.rambo.designMethod.factory.abstractFactory;

/**
 * @author ：baizhansi
 * @date ：Created in 2020/10/23 18:16
 */
public class HighEndProtectiveSuit implements IProtectiveSuit {
    @Override
    public void showSuit() {
        System.out.println("我是高端防护服");
    }
}
