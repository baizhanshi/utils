package com.rambo.suanfa;

/**
 *      1
 *   2     3
 * 4   5  6
 *
 * @author ：baizhanshi
 * @date ：Created in 2021/7/1 17:25
 *
 * 5+2+1+3+6=17
 */
public class 二叉树最大路径之和 {

    // 因为maxPathSum不一定经过根节点，所以用maxValue整个遍历过程中出现过的最大值
    private static int maxValue = 0;

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1, null, null);
        TreeNode node2 = new TreeNode(2, null, null);
        TreeNode node3 = new TreeNode(3, null, null);
        TreeNode node4 = new TreeNode(4, null, null);
        TreeNode node5 = new TreeNode(5, null, null);
        TreeNode node6 = new TreeNode(6, null, null);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        System.out.println(maxPathSum(node1));
    }

    public static int maxPathSum(TreeNode root) {
        maxPathDown(root);
        return maxValue;
    }

    private static int maxPathDown(TreeNode node) {
        if (node == null) {
            return 0;
        }
        //因为节点的值可以为负数，所以最大值取0和子树值的较大者
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        //如果将当前root作为根节点，那么最大值是root.val+左子树最大值+右子树最大值
        maxValue = Math.max(maxValue, left + right + node.val);
        //只能返回左右子树中较大值加上root.val
        return Math.max(left, right) + node.val;
    }
}