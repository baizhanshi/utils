package com.rambo.java8.inter;

/**
 * @author baizhanshi on 2019/4/21.
 */
public class InterfaceImpl implements Interface1, Interface2 {

    @Override
    public String getName() {
        return Interface2.super.getName();
    }

    public static void main(String[] args) {
        System.out.println(new InterfaceImpl().getName());
    }
}
