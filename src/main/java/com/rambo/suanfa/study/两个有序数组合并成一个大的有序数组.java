package com.rambo.suanfa.study;

/**
 * @author ：baizhanshi
 * @date ：Created in 2021/10/24 6:24
 */
public class 两个有序数组合并成一个大的有序数组 {
    public static void main(String[] args) {
        int[] nums = {2, 4, 6, 8};
        int[] nums1 = {1, 3, 5, 7};

        int[] newNums = Sort(nums, nums1);
        for (int i = 0; i < newNums.length - 1; i++) {
            System.out.print(newNums[i] + " ");
        }

    }

    /**
     * 归并排序思想
     *
     * @param nums
     * @param nums1
     * @return
     */
    public static int[] Sort(int[] nums, int[] nums1) {
        int[] newArr = new int[nums.length + nums1.length];
        int i = 0, j = 0, k = 0;
        while (i < nums.length && j < nums1.length) {
            if (nums[i] < nums1[j]) {
                newArr[k] = nums[i];
                i++;
                k++;
            } else {
                newArr[k] = nums1[j];
                j++;
                k++;
            }
        }

        while (i < nums.length)
            newArr[k++] = nums[i++];
        while (j < nums1.length)
            newArr[k++] = nums1[j++];
        return newArr;
    }
}
