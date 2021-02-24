package com.rambo.suanfa;

/**
 * 插入排序算法
 * 每步将一个待排序的记录，按其顺序码大小插入到前面已经排序好的序列的合适位置（从后向前找到合适位置后），
 * 直到全部插入排序完为止。
 *
 * @author ：baizhansi
 * @date ：Created in 2021/1/10 20:18
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] numbers = {3, 1, 8, 5, 2, 6};
        int[] ints = insertSort(numbers);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
        }
    }

    static int[] insertSort(int[] numbers) {
        int size = numbers.length;
        int temp = 0;
        int j = 0;

        for (int i = 0; i < size; i++) {//i=4
            temp = numbers[i];//temp=2
            //假如temp比前面的值小，则将前面的值后移
            for (j = i; j > 0 && temp < numbers[j - 1]; j--) {//j=4;j>0&&2<numbers[3]=5 符合条件的后移
                numbers[j] = numbers[j - 1];//后移动一位
            }
            numbers[j] = temp;//当前值插入到数组中 j的值就是当前循环的i的值
        }
        return numbers;
    }
}
