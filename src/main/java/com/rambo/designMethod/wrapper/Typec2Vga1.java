package com.rambo.designMethod.wrapper;

/**
 * 类的适配器模式（子类继承类实现新的接口）
 * 
 * @author ：baizhansi
 * @date ：Created in 2020/10/27 14:34
 */
public class Typec2Vga1 extends Phone implements Vga {
    @Override
    public void vgaInterface() {
        typecPhone();
        System.out.println("接收到Type-c口信息，信息转换成VGA接口中...");
        System.out.println("信息已转换成VGA接口，显示屏可以对接。");
    }
}
