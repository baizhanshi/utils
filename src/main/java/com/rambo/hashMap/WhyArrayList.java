package com.rambo.hashMap;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author ：baizhanshi
 * @date ：Created in 2020/6/10 18:37
 */
public class WhyArrayList extends CopyOnWriteArrayList {
    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left (subtracts one from their
     * indices).  Returns the element that was removed from the list.
     *
     * @param obj
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public boolean remove(Object obj) {
        return super.remove(obj);
    }
}
