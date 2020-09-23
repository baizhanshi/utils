package com.rambo.redisLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ：baizhanshi
 * @date ：Created in 2020/6/23 11:21
 */
@RestController
@RequestMapping("/redis")
public class TestZSet {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public void add() {
        //向集合中插入元素，并设置分数
        redisTemplate.opsForZSet().add("key", "p1", 2.1);
        //向集合中插入多个元素
        DefaultTypedTuple<String> tuple1 = new DefaultTypedTuple<String>("p2", 1.1);
        DefaultTypedTuple<String> tuple2 = new DefaultTypedTuple<String>("p3", 3.1);
        redisTemplate.opsForZSet().add("key", new HashSet<>(Arrays.asList(tuple1, tuple2)));

        //从集合中删除指定元素
        redisTemplate.opsForZSet().remove("key", "p1");
        //指定元素加分数
        Double score = redisTemplate.opsForZSet().incrementScore("key", "p1", 2);
        System.out.println(score);//返回加分后的得分

        //返回集合内元素的排名，以及分数（从小到大）
        Set<ZSetOperations.TypedTuple<String>> tuples = redisTemplate.opsForZSet().rangeWithScores("key", 0, -1);
        for (ZSetOperations.TypedTuple<String> tuple : tuples) {
            System.out.println(tuple.getValue() + " : " + tuple.getScore());
        }

        //返回集合内元素在指定分数范围内的排名（从小到大）
        Set<String> ranking = redisTemplate.opsForZSet().rangeByScore("key", 0, 5);
        System.out.println(ranking);
        //带偏移量和个数，下例意为从第二个开始，要三个
        Set<String> ranking2 = redisTemplate.opsForZSet().rangeByScore("key", 0, 5, 1, 3);
        System.out.println(ranking2);
        //也可以带分数返回，类似于test5

        //返回集合内指定分数范围的成员个数
        Long count = redisTemplate.opsForZSet().count("key", 0, 2);
        System.out.println(count);
        //返回集合内的成员个数
        Long size = redisTemplate.opsForZSet().size("key");//等同于zCard(key);
        System.out.println(size);

        //获得指定元素的分数
        Double score1 = redisTemplate.opsForZSet().score("key", "p1");
        System.out.println(score1);
        //删除指定索引范围的元素
        redisTemplate.opsForZSet().removeRange("key", 0, 0);


        //删除指定分数范围内的元素
        redisTemplate.opsForZSet().removeRangeByScore("key", 4, 5);

        //按照排名先后(从小到大)打印指定区间内的元素, -1为打印全部
        Set<String> range = redisTemplate.opsForZSet().range("key", 0, -1);
        //reverseRange 从大到小 
        System.out.println(range);

    }
}
