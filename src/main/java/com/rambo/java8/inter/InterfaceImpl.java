package com.rambo.java8.inter;

/**
 * @author baizhanshi on 2019/4/21.
 */
public class InterfaceImpl implements Interface1, Interface2 {

    /**
     * 接口冲突。
     * 如果一个父接口提供一个默认方法，而另一个接口也提供了一个具有相同名称和参数列表的方法（不管方法是否是默认方法），
     * 那么必须覆盖该方法来解决冲突。
     * 比如：Interface2
     * @return
     */
    @Override
    public String getName() {
        return Interface2.super.getName();
    }

    public static void main(String[] args) {
        System.out.println(new InterfaceImpl().getName());
        System.out.println(Interface3.send());//接口中的静态方法
    }
}
