package com.rambo.designMethod.iterator;

import java.util.Iterator;

/**
 * 迭代器模式
 * @author ：baizhanshi
 * @date ：Created in 2021/6/22 15:13
 */
public class TestIterator {
    public static void main(String[] args) {
        Aggregate ag = new ConcreteAggregate();
        ag.add("中山大学");
        ag.add("华南理工");
        ag.add("韶关学院");
        System.out.println("聚合的内容有：");
        Iterator it = ag.getIterator();
        while (it.hasNext()) {
            Object ob = it.next();
            System.out.println(ob.toString());
        }
        System.out.println("---------------------------");
        ag.remove("中山大学");
        Iterator it1 = ag.getIterator();
        while (it1.hasNext()) {
            Object ob = it1.next();
            System.out.println(ob.toString());
        }
    }
}
