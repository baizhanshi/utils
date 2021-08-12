package com.rambo.suanfa;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author ：baizhanshi
 * @date ：Created in 2021/8/12 18:56
 */
public class 找出最小整数 {
    public static void main(String[] args) {
        int[] nums = {7, 8, -3};
        System.out.println(getSmallNum(nums));
    }

    private static Integer getSmallNum(int[] nums) {
        Set<Integer> numSet = new TreeSet();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && !numSet.contains(nums[i])) {
                numSet.add(nums[i]);
            }
        }
        int a = 1;
        while (a < numSet.size() + 1) {
            if (!numSet.contains(a)) {
                return a;
            }
            a++;
        }
        return a;
    }
}
