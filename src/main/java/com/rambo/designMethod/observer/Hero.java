package com.rambo.designMethod.observer;

/**
 * @author ：baizhansi
 * @date ：Created in 2020/10/26 15:17
 */
public class Hero extends Subject {
    public void move() {
        System.out.println("主角向前移动");
        notifyObservers();
    }
}
