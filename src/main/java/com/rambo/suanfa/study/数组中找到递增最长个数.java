package com.rambo.suanfa.study;

/**
 * 在一个数组中找到连续递增的数字个数
 *
 * @author ：baizhanshi
 * @date ：Created in 2021/9/25 8:51
 */
public class 数组中找到递增最长个数 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 3, 4, 3, 4, 5, 6, 7, 8};
        System.out.println(findLength(nums));
    }

    /**
     * 贪心算法求最长递增个数
     *
     * @param nums
     * @return
     */
    public static int findLength(int[] nums) {
        //初始值0
        int start = 0;
        //最大长度为0
        int maxLength = 0;
        for (int i = 1; i < nums.length; i++) {
            //如果后一位小于等于前一位，就要重新开始计算
            if (nums[i] <= nums[i - 1]) {
                start = i;
            }
            //开始比较当前已经遍历的长度和最大长度那个最大
            maxLength = Math.max(maxLength, i - start + 1);
        }
        return maxLength;
    }
}
