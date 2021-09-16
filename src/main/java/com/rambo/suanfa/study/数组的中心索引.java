package com.rambo.suanfa.study;

import java.util.Arrays;

/**
 * 中心下标的意思是两边的数字之和相等 比如1+7+3 = 5+6
 * 找不到返回-1
 *
 * @author ：baizhanshi
 * @date ：Created in 2021/9/16 20:51
 */
public class 数组的中心索引 {

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println(priotindex(nums));
    }

    private static int priotindex(int[] nums) {
        //先求和
        int sum = Arrays.stream(nums).sum();
        //从前往后先加
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            //如果前边相加和sum-total相等，就找到了下标
            if (total == sum) {
                return i;
            }
            //否则剩余总数减去当前值
            sum = sum - nums[i];
        }
        return -1;
    }
}