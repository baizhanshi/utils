package com.rambo.designMethod.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 具体容器
 * @author ：BAIZHANSHI998
 * @date ：Created in 2021-6-22 14:37
 */
public class ConcreteAggregate implements Aggregate {

    private List<Object> list = new ArrayList<>();


    @Override
    public void add(Object obj) {
        list.add(obj);
    }

    @Override
    public void remove(Object obj) {
        list.remove(obj);
    }

    @Override
    public Iterator getIterator() {
        return new ConcreteIterator(list);
    }
}
