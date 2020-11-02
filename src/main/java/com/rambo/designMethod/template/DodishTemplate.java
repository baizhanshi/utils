package com.rambo.designMethod.template;

/**
 * @author ：baizhansi
 * @date ：Created in 2020/10/29 11:25
 */
public abstract class DodishTemplate {
    /**
     * 具体的整个过程
     */
    protected void dodish(){
        this.preparation();
        this.doing();
        this.carriedDishes();
    }
    /**
     * 备料
     */
    public abstract void preparation();
    /**
     * 做菜
     */
    public abstract void doing();
    /**
     * 上菜
     */
    public abstract void carriedDishes ();
}
