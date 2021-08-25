package com.rambo.redisLock.bloom;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ：baizhanshi
 * @date ：Created in 2021/8/25 19:05
 */
@RestController
@RequestMapping(value = "/bloom")
public class BloomFilterController {

    @Resource
    private RedisBloomFilter redisBloomFilter;

    @RequestMapping(value = "/set", method = RequestMethod.GET)
    public void testFilter() {
        redisBloomFilter.put("10087");
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public void getFilter() {
        boolean exist = redisBloomFilter.isExist("10087");
        System.out.println(exist);
    }

}