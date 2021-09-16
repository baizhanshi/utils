package com.rambo.suanfa.study;

/**
 * @author ：baizhanshi
 * @date ：Created in 2021/9/16 19:11
 */
public class 有序数组去重 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 3, 4};
        System.out.println(repalce(nums));
    }

    /**
     * 双指针实现逻辑
     *
     * @param nums
     * @return
     */
    private static int repalce(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}