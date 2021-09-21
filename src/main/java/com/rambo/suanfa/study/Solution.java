package com.rambo.suanfa.study;

import java.util.HashMap;
import java.util.Map;

/**
 * 输出两个数之和等于目标对象的索引位置
 *
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
        System.out.println("------------------");
        int[] ints1 = solution(nums, target);
        for (int anInt : ints1) {
            System.out.println(anInt);
        }
    }

    /**
     * 暴力解法O（N*N）
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] solution(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * 暂存法 O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
