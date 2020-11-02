package com.rambo.designMethod.observer;

/**
 *
 * @author ：baizhansi
 * @date ：Created in 2020/10/26 15:05
 */
public class Monster implements Observer {

    @Override
    public void update() {
        if (inRange()) {
            System.out.println("怪物 对主角攻击！");
        }
    }

    private boolean inRange() {
        //判断主角是否在自己的影响范围内，这里忽略细节，直接返回true
        return true;
    }
}
