package com.rambo.designMethod.template;

/**
 * @author ：baizhansi
 * @date ：Created in 2020/10/29 11:25
 */
public class EggsWithTomato extends DodishTemplate {
    @Override
    public void preparation() {
        System.out.println("洗并切西红柿，打鸡蛋。");
    }

    @Override
    public void doing() {
        System.out.println("鸡蛋倒入锅里，然后倒入西红柿一起炒。");
    }

    @Override
    public void carriedDishes() {
        System.out.println("将炒好的西红寺鸡蛋装入碟子里，端给客人吃。");
    }
}
