package com.rambo.suanfa;

/**
 * 快速排序 选择一个数作为轴心点，一次和后面的比较，小的去左边，大的去右边，迭代
 * 
 * @author ：baizhanshi
 * @date ：Created in 2021/1/18 14:42
 */
public class Quicksort {
    public static void main(String[] args) {
        int[] numbers = { 3, 1, 8, 5, 2, 6 };
        int[] ints = quicksort(numbers, 0, 5);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
        }

    }

    static int[] quicksort(int[] numbers, int left, int right) {
        if (left < right) {
            int key = numbers[left];//3
            int low = left;//0
            int high = right;//5
            while (low < high) {
                while (low < high && numbers[high] > key) {//6>3
                    high--;
                }
                numbers[low] = numbers[high];
                while (low < high && numbers[low] < key) {
                    low++;
                }
                numbers[high] = numbers[low];
            }
            numbers[low] = key;
            quicksort(numbers, left, low - 1);
            quicksort(numbers, low + 1, right);
        }
        return numbers;
    }

}
