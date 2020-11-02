package com.rambo.designMethod.factory.factoryMethod;

/**
 * 工厂方法测试类（每个实例有自己的工厂类实现类，调用者不用传递参数）
 * 、但是 后续增加实例会无限制的增加工厂子类，调用方也需要知道子类工厂的信息
 * 
 * @author ：baizhansi
 * @date ：Created in 2020/10/23 17:57
 */
public class TestFactoryMethod {
    public static void main(String[] args) {
        IMaskFactory highEndFactory = new HighEndFactory();//多态模式创建调用
        highEndFactory.createMask().show();
        IMaskFactory lowEndFactory = new LowEndFactory();
        lowEndFactory.createMask().show();
    }
}
