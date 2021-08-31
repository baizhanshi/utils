package com.rambo.designMethod.template;


import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * java 8改造模板模式
 *
 * @author ：baizhanshi
 * @date ：Created in 2021/8/31 19:19
 */
public class Java8Template {

    private void execute(Consumer<String> consumer) {
        this.init();
        consumer.accept(null);
        this.carriedDishes();
    }

    private void execute(Supplier<String> supplier, Consumer<String> consumer) {
        this.init();
        String number = supplier.get();
        if (number.startsWith("fish")) {
            System.out.println("do fish");
        } else {
            System.out.println("doing others");
        }
        consumer.accept(null);
        this.carriedDishes();
    }

    private void init() {
        System.out.println("我是初始化方法，无需继承！");
    }

    /**
     * 上菜
     */
    private void carriedDishes() {
        System.out.println("上菜！");
    }

    public void doing(String amount) {
        execute(a -> System.out.println(amount));
    }

    public void doingFish(String amount) {
        execute(() -> "fishing", a -> System.out.println(amount));
    }
}
