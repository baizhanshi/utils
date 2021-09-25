package com.rambo.suanfa.study;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 4
 * /   \
 * 2     7
 * / \   /
 * 1  3  6
 * ---------\
 * ----------9
 *
 * @author ：baizhanshi
 * @date ：Created in 2021/9/25 8:30
 */
public class 二叉树最小深度 {
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

        System.out.println(minDept(node1));
        System.out.println(minDept1(node1));
    }

    /**
     * 深度优先（从底部往上开始算起）
     *
     * @param node
     * @return
     */
    public static int minDept(TreeNode node) {
        if (node == null) {
            return 0;
        }
        //如果找到了子节点，深度就是1
        if (node.left == null && node.right == null) {
            return 1;
        }
        //设置一个最小值，后续左右两侧都和最小值比较取最小值
        int min = Integer.MAX_VALUE;
        if (node.left != null) {
            min = Math.min(min, minDept(node.left));
        }
        if (node.right != null) {
            min = Math.min(min, minDept(node.right));
        }
        return min + 1;
    }

    /**
     * 广度优先（从根节点往下开始算起）
     *
     * @param root
     * @return
     */
    public static int minDept1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //创建一个队列 先进先出
        Queue<TreeNode> queue = new LinkedList<>();
        //根的初始深度为1，并放入队列
        root.deep = 1;
        queue.offer(root);
        //当队列不为空的结束循环
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            //找到子节点结束循环
            if (node.left == null && node.right == null) {
                return node.deep;
            }
            //左节点不为空，深度是根节点+1
            if (node.left != null) {
                node.left.deep = node.deep + 1;
                queue.offer(node.left);
            }
            //右节点不为空，深度是根节点+1
            if (node.right != null) {
                node.right.deep = node.deep + 1;
                queue.offer(node.right);
            }
        }
        return 0;
    }
}