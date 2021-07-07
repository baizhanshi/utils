package com.rambo.suanfa;

/**
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1  3  6   9
 *
 * @author ：baizhanshi
 * @date ：Created in 2021/6/25 16:39
 */
public class 翻转二叉树 {
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
        System.out.println("反转前：" + node1.toString());
        TreeNode TreeNode = invertTree(node1);
        System.out.println("反转后：" + TreeNode.toString());
    }

    public static TreeNode invertTree(TreeNode root) {
        //跳出递归条件是节点为空或者左子节点为空并且右子节点为空
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        //翻转左子树
        TreeNode left = invertTree(root.left);
        //翻转右子树
        TreeNode right = invertTree(root.right);
        //左右子树交换位置~
        root.left = right;
        root.right = left;
        return root;

    }
}
