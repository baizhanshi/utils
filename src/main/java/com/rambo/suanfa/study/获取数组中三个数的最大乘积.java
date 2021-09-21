package com.rambo.suanfa.study;

import java.util.Arrays;

/**
 * 先排序，（1）三个最大值正数的乘积，（2）两负（绝对值最大）一正（绝对值最大）的乘积
 *
 * @author ：baizhanshi
 * @date ：Created in 2021/9/21 9:33
 */
public class 获取数组中三个数的最大乘积 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        System.out.println(sort(nums));
    }

    /**
     * 先排序再算乘积
     *
     * @param nums
     * @return
     */
    public static int sort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 3] * nums[n - 2] * nums[n - 1]);
    }

}
