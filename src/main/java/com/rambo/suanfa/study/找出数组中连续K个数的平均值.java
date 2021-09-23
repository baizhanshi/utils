package com.rambo.suanfa.study;

/**
 * 一个数组中 找出连续K个数之和的最大值的平均值
 * 比如：12-5-6+50=51/4=12.75
 *
 * @author ：baizhanshi
 * @date ：Created in 2021/9/23 20:16
 */
public class 找出数组中连续K个数的平均值 {
    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        System.out.println(findMaxAverage(nums, 4));
    }

    /**
     * 滑动窗口算法
     *
     * @param nums
     * @param k
     * @return
     */
    private static double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        //先计算出到K之间的所有数字之和
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        //第一个K长度的窗口之和赋值给最大值，后续进行最大值比较
        int maxSum = sum;
        //循环遍历K以后的所有数据
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i - k] + nums[i];
            maxSum = Math.max(sum, maxSum);
        }
        return 1.0 * maxSum / k;
    }
}
