package com.rambo.designMethod.iterator;

import java.util.Iterator;
import java.util.List;

/**
 * 具体迭代器
 * @author ：baizhanshi
 * @date ：Created in 2021/6/22 15:12
 */
public class ConcreteIterator implements Iterator {
    private List<Object> list = null;
    private int index = 0;

    public ConcreteIterator(List<Object> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return index != list.size();
    }

    @Override
    public Object next() {
        Object obj = null;
        if (this.hasNext()) {
            obj = list.get(index++);
        }
        return obj;
    }
}
