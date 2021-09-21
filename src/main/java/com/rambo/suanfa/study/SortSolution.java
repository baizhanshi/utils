package com.rambo.suanfa.study;


/**
 * 已排序的数组
 * 输出两个数之和等于目标对象的索引位置
 *
 * @author ：baizhanshi
 * @date ：Created in 2020/7/8 16:42
 */
public class SortSolution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 6, 7};
        int target = 9;
        int[] ints = twoSearch(nums, target);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
        System.out.println("------------------");
        int[] ints1 = twoPoint(nums, target);
        for (int anInt : ints1) {
            System.out.println(anInt);
        }
    }

    /**
     * 二分法
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSearch(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int low = i, high = nums.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (nums[mid] == target - nums[i]) {
                    return new int[]{i, mid};
                } else if (nums[mid] > target - nums[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return new int[0];
    }

    /**
     * 双指针
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoPoint(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int sum = nums[low] + nums[high];
            if (sum == target) {
                return new int[]{low, high};
            } else if (sum < target) {
                low++;
            } else {
                high--;
            }
        }
        return new int[0];
    }
}
