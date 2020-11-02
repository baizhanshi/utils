package com.rambo.designMethod.factory.simpleFactory;

import com.rambo.designMethod.factory.IMask;

/**
 * 简单工厂测试类（下次再加实例还要添加实现类和修改调用逻辑，难以维护并且违背了开放封闭原则）
 * 
 * @author ：baizhansi
 * @date ：Created in 2020/10/23 17:53
 */
public class TestSimpleFactory {
    public static void main(String[] args) {
        MaskFactory factory = new MaskFactory();
        IMask maskA = factory.createMask("高端口罩");
        maskA.show();
        IMask maskB = factory.createMask("低端口罩");
        maskB.show();
    }
}
