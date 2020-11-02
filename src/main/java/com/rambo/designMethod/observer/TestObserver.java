package com.rambo.designMethod.observer;

/**
 * 观察者测试类
 * @author ：baizhansi
 * @date ：Created in 2020/10/26 15:19
 */
public class TestObserver {
    public static void main(String[] args) {
        //初始化对象
        Hero hero = new Hero();
        Monster monster = new Monster();
        Trap trap = new Trap();
        //注册观察者
        hero.attachObserver(monster);
        hero.attachObserver(trap);
        //移动事件
        hero.move();
    }
}
