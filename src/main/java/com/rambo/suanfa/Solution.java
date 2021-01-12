package com.rambo.suanfa;

import java.util.HashMap;
import java.util.Map;

/**
 * 输出两个数之和等于目标对象的索引位置
 * @author ：baizhanshi
 * @date ：Created in 2020/7/8 16:42
 */
public class Solution {
    public static void main(String[] args) {
        int[] nums = {2, 15, 7, 11, 12};
        int target = 9;
        int[] ints = twoSum(nums, target);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
