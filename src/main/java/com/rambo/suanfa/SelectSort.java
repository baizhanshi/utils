package com.rambo.suanfa;

/**
 * 选择排序
 *
 * 在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
 * 然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
 * @author ：baizhanshi
 * @date ：Created in 2021/1/18 14:27
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] numbers = { 3, 1, 8, 5, 2, 6 };
        int[] ints = selectSort(numbers);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
        }

    }

    static int[] selectSort(int[] numbers) {
        int size = numbers.length; //数组长度
        for (int i = 0; i < size; i++) {
            int k = i; //待确定的位置
            //选择出应该在第i个位置的数
            for (int j = size - 1; j > i; j--) {
                if (numbers[j] < numbers[k]) {//numbers[0]=3 找到比当前值小的数的索引
                    k = j;
                }
            }
            //交换两个数
            int temp = numbers[i];
            numbers[i] = numbers[k];
            numbers[k] = temp;
        }
        return numbers;
    }
}
