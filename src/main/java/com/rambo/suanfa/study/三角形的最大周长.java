package com.rambo.suanfa.study;

import java.util.Arrays;

/**
 * 从一个数组中找出符合组成三角形的两边之和大于第三边的数字
 * 获取三个数之和的最大值
 *
 * @author ：baizhanshi
 * @date ：Created in 2021/9/28 14:17
 */
public class 三角形的最大周长 {
    public static void main(String[] args) {
        int[] nums = {3, 6, 2, 3};
        System.out.println(largest(nums));
    }

    /**
     * 贪心算法
     * @param nums
     * @return
     */
    private static int largest(int[] nums) {
        //先进行排序
        Arrays.sort(nums);
        //倒叙看后边三个数是否满足条件
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i - 2] + nums[i - 1] > nums[i]) {
                return nums[i - 2] + nums[i - 1] + nums[i];
            }
        }
        return 0;
    }
}
