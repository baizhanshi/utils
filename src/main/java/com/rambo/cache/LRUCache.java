package com.rambo.cache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 默认是按插入顺序排序，如果指定按访问顺序排序，那么调用get方法后，
 * 会将这次访问的元素移至链表尾部，不断访问可以形成按访问顺序排序的链表。
 * 可以重写removeEldestEntry方法返回true值指定插入元素时移除最老的元素。
 * @author ：baizhanshi
 * @date ：Created in 2020/8/3 15:05
 */
public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private int cacheSize;

    public LRUCache(int cacheSize) {
        super(16, (float) 0.75, true);
        this.cacheSize = cacheSize;
    }

    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > cacheSize;
    }
}
