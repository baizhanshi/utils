package com.rambo.suanfa;

/**
 * 插入排序算法
 *
 * @author ：baizhansi
 * @date ：Created in 2021/1/10 20:18
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] numbers = {3, 6, 8, 5, 2, 6};
        int[] ints = insertSort(numbers);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    static int[] insertSort(int[] numbers) {
        int size = numbers.length;
        int temp = 0;
        int j = 0;

        for (int i = 0; i < size; i++) {
            temp = numbers[i];
            //假如temp比前面的值小，则将前面的值后移
            for (j = i; j > 0 && temp < numbers[j - 1]; j--) {
                numbers[j] = numbers[j - 1];
            }
            numbers[j] = temp;
        }
        return numbers;
    }
}
