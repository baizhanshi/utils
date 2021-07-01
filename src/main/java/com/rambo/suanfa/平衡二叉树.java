package com.rambo.suanfa;

import lombok.Data;

/**
 * 给定二叉树 [3,9,20,null,null,15,7]
  3
 / \
 9  20
   /  \
  15   7
 返回 true
 给定二叉树 [1,2,2,3,3,null,null,4,4]
       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
 返回 false
 * @author ：baizhanshi
 * @date ：Created in 2021/3/19 10:24
 */
public class 平衡二叉树 {

    // 后序遍历，避免重复对左右子树判断平衡性
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean isLeft = isBalanced(root.left);
        boolean isRight = isBalanced(root.right);
        return isLeft && isRight && Math.abs(getMaxDepth(root.left) - getMaxDepth(root.right)) <= 1 ? true : false;
    }

    //获取深度
    private int getMaxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftDepth = getMaxDepth(root.left);
        int rightDepth = getMaxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

}

@Data
class TreeNode {
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
