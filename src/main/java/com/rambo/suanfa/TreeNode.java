package com.rambo.suanfa;

/**
 * @author ：baizhanshi
 * @date ：Created in 2021/7/7 16:22
 */
public class TreeNode {
    int      val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
