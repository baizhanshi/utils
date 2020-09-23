package com.rambo.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ：baizhanshi
 * @date ：Created in 2020/8/3 15:06
 */
public class LRUCacheTest {
    private static final Logger              log   = LoggerFactory.getLogger(LRUCacheTest.class);
    private static LRUCache<String, Integer> cache = new LRUCache<>(10);

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            cache.put("k" + i, i);
        }
        log.info("all cache :'{}'", cache);
        cache.get("k3");
        log.info("get k3 :'{}'", cache);
        cache.get("k4");
        log.info("get k4 :'{}'", cache);
        cache.get("k4");
        log.info("get k4 :'{}'", cache);
        cache.put("k" + 10, 10);
        log.info("After running the LRU algorithm cache :'{}'", cache);
    }
}
