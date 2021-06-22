package com.rambo.designMethod.iterator;

import java.util.Iterator;

/**
 * 抽象容器
 * @author ：baizhanshi
 * @date ：Created in 2021/6/22 15:11
 */
public interface Aggregate {

    void add(Object obj);

    void remove(Object obj);

    Iterator getIterator();
}
