package com.rambo.designMethod.wrapper;

/**
 * 对象的适配器模式
 * 
 * @author ：baizhansi
 * @date ：Created in 2020/10/27 14:35
 */
public class Typec2Vga2 implements Vga {

    private Phone phone;

    public Typec2Vga2(Phone phone) {
        this.phone = phone;
    }

    @Override
    public void vgaInterface() {
        if (phone != null) {
            phone.typecPhone();
            System.out.println("接收到Type-c口信息，信息转换成VGA接口中...");
            System.out.println("信息已转换成VGA接口，显示屏可以对接。");
        }
    }
}
