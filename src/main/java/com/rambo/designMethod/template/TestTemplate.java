package com.rambo.designMethod.template;

/**
 * 模板模式测试类（抽象方法，继承子类）
 * @author ：baizhansi
 * @date ：Created in 2020/10/29 11:26
 */
public class TestTemplate {
    public static void main(String[] args) {
        DodishTemplate template = new EggsWithTomato();
        template.dodish();
    }
}
