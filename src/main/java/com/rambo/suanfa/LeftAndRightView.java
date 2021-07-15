package com.rambo.suanfa;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1  3  6   9
 *
 * @author ：BAIZHANSHI
 * @date ：Created in 2021-7-15 16:12
 */
public class LeftAndRightView {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4, null, null);
        TreeNode node2 = new TreeNode(2, null, null);
        TreeNode node3 = new TreeNode(7, null, null);
        TreeNode node4 = new TreeNode(1, null, null);
        TreeNode node5 = new TreeNode(3, null, null);
        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode node7 = new TreeNode(9, null, null);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        leftView(node1);
        System.out.println("----------");
        rightView(node1);
    }


    /**
     * 二叉树左视图
     *
     * @param node
     */
    private static void leftView(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        //设置 size 和 child 两个标记，child在循环中会变，size不会变，作为循环条件
        //第一层只有根节点1个，所以size = 1
        int size = 1;
        //记录孩子数
        int child;
        while (!queue.isEmpty()) {
            //初始化孩子数为 0
            child = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node1 = queue.poll();
                // i = 0,说明是该层第一个结点
                if (i == 0) {//唯一的区别点
                    System.out.println(node1.val);
                }
                if (node1.left != null) {
                    queue.offer(node1.left);
                    child++;
                }
                if (node1.right != null) {
                    queue.offer(node1.right);
                    child++;
                }
            }
            size = child;
        }
    }

    /**
     * 二叉树左右视图
     *
     * @param node
     */
    private static void rightView(TreeNode node) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        //设置 size 和 child 两个标记，child在循环中会变，size不会变，作为循环条件
        //第一层只有根节点1个，所以size = 1
        int size = 1;
        //记录孩子数
        int child;
        while (!queue.isEmpty()) {
            //初始化孩子数为 0
            child = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node1 = queue.poll();
                // i = 0,说明是该层第一个结点
                if (i == size - 1) {
                    System.out.println(node1.val);
                }
                if (node1.left != null) {
                    queue.offer(node1.left);
                    child++;
                }
                if (node1.right != null) {
                    queue.offer(node1.right);
                    child++;
                }
            }
            size = child;
        }
    }
}


