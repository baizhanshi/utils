package com.rambo.suanfa;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
/**
 * @author ：baizhanshi
 * @date ：Created in 2021/9/4 8:05
 */
public class 数组数字全排列 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = recover(nums, 0);
        System.out.println(res.toString());
        System.out.println("-------------------");
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = Lists.newArrayList();
        List<List<Integer>> permute = backtrack(list, tempList, nums);
        System.out.println(permute.toString());
    }


    /**
     * 回溯算法
     *
     * @param list
     * @param tempList
     * @param nums
     * @return
     */
    private static List<List<Integer>> backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        //终止条件，如果数字都被使用完了，说明找到了一个排列，（可以把它看做是n叉树到
        //叶子节点了，不能往下走了，所以要返回）
        if (tempList.size() == nums.length) {
            //因为list是引用传递，这里必须要重新new一个
            list.add(Lists.newArrayList(tempList));
            return list;
        }
        //（可以把它看做是遍历n叉树每个节点的子节点）
        for (int i = 0; i < nums.length; i++) {
            //因为不能有重复的，所以有重复的就跳过
            if (tempList.contains(nums[i])) {
                continue;
            }
            //选择当前值
            tempList.add(nums[i]);
            //递归（可以把它看做遍历子节点的子节点）
            backtrack(list, tempList, nums);
            //撤销选择，把最后一次添加的值给移除
            tempList.remove(tempList.size() - 1);
        }
        return list;
    }

    /**
     * 递归方式，先确定2和3的排列组合，1往里面插入即可
     *
     * @param nums
     * @param index
     * @return
     */
    private static List<List<Integer>> recover(int[] nums, int index) {
        List<List<Integer>> res = Lists.newArrayList();
        if (nums.length == 0) {
            return res;
        }
        //递归的终止条件，如果到最后一个数组，直接把它放到res中
        if (index == nums.length - 1) {
            //创建一个临时数组
            List<Integer> temp = new ArrayList<>();
            //把数字nums[index]加入到临时数组中
            temp.add(nums[index]);
            res.add(temp);
            return res;
        }

        //计算后面数字的全排列
        List<List<Integer>> subList = recover(nums, index + 1);
        //集合中每个子集的长度
        int count = subList.get(0).size();
        //遍历集合subList的子集
        for (int i = 0, size = subList.size(); i < size; i++) {
            //把当前数字nums[index]添加到子集的每一个位置
            for (int j = 0; j <= count; j++) {
                List<Integer> temp = new ArrayList<>(subList.get(i));
                temp.add(j, nums[index]);
                res.add(temp);
            }
        }
        return res;
    }
}
