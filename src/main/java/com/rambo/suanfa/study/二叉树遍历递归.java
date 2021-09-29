package com.rambo.suanfa.study;

/**
 *          1
 *      /        \
 *      2          3
 *     /   \
 *    4     5
 *       /   \
 *      6     7
 *
 * @author ：baizhanshi
 * @date ：Created in 2021/9/29 11:16
 */
public class 二叉树遍历递归 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1, null, null);
        TreeNode node2 = new TreeNode(2, null, null);
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node6 = new TreeNode(6, null, null);
        TreeNode node7 = new TreeNode(7, null, null);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.left = node6;
        node5.right = node7;
        //前序遍历 1 2 4 5 6 7 3
        qianxu(node1);
        System.out.println("---------------------");
        //中序遍历 4 2 6 5 7 1 3
        zhongxu(node1);
        System.out.println("---------------------");
        //后序遍历 4 6 7 5 2 3 1
        houxu(node1);
    }
    /**
     * 后序遍历  左右根
     *
     * @param root
     */
    private static void houxu(TreeNode root) {
        if (root == null) {
            return;
        }
        houxu(root.left);
        houxu(root.right);
        System.out.print(root.val + " ");
    }

    /**
     * 中序遍历  左根右
     *
     * @param root
     */
    private static void zhongxu(TreeNode root) {
        if (root == null) {
            return;
        }
        zhongxu(root.left);
        System.out.print(root.val + " ");
        zhongxu(root.right);
    }

    /**
     * 前序遍历  根左右
     *
     * @param root
     */
    private static void qianxu(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        qianxu(root.left);
        qianxu(root.right);
    }
}
