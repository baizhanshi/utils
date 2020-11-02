package com.rambo.designMethod.wrapper;

/**
 * @author ：baizhansi
 * @date ：Created in 2020/10/27 14:38
 */
public class TestWrapper {
    public static void main(String[] args) {
        //第一种适配器用法(类的适配器模式)
        System.out.println("-------------第一种适配器------------");
        Vga vga = new Typec2Vga1();
        vga.vgaInterface();//适配器将typec转换成vga
        System.out.println("显示屏对接适配器，手机成功投影到显示屏!");

        //第二种适配器用法（对象适配器模式）
        System.out.println("-------------第二种适配器------------");
        Typec2Vga2 typec2Vga1 = new Typec2Vga2(new Phone());
        typec2Vga1.vgaInterface();//适配器将typec转换成vga
        System.out.println("显示屏对接适配器，手机成功投影到显示屏!");

        //第三种适配器用法（接口适配器模式）
        System.out.println("-------------第三种适配器------------");
        VgaAdapter vgaAdapter = new VgaAdapter();
        vgaAdapter.typec();
        vgaAdapter.typec2vga();//适配器将typec转换成vga
        System.out.println("显示屏对接适配器，手机成功投影到显示屏!");
    }

}
