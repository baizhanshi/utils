package com.rambo.designMethod.observer;

/**
 * 陷阱
 * @author ：baizhansi
 * @date ：Created in 2020/10/26 15:16
 */
public class Trap implements Observer {
    @Override
    public void update() {
        if (inRange()) {
            System.out.println("陷阱 困住主角！");
        }
    }

    private boolean inRange() {
        //判断主角是否在自己的影响范围内，这里忽略细节，直接返回true
        return true;
    }
}
