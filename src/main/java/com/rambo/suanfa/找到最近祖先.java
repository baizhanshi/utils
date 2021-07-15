package com.rambo.suanfa;
/**
 * 二叉树最近祖先
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1  3  6   9
 *
 * @author ：BAIZHANSHI
 * @date ：Created in 2021-7-15 9:54
 */
public class 找到最近祖先 {
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
        System.out.println(lowestCommonAncestor(node1, 1, 6));
    }

    /**
     * 根据输入的节点找到公共的祖先
     * @param root 树结构
     * @param o1 节点
     * @param o2 节点
     * @return
     */
    public static int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        //根节点为null 直接返回
        if (root == null) {
            return 0;
        }
        //p=root,且q在root的左或右子树中；
        //q=root，且p在root的左或右子树中；
        //p或q其中一个是另一个的祖先结点，返回是祖先结点的那个
        if (root.val == o1 || root.val == o2) {
            return root.val;
        }
        //p和q在root的子树中，且分列root的异侧（即分别在左、右子树中）
        // 在左子树寻找p和q的最近公共祖先
        int left = lowestCommonAncestor(root.left, o1, o2);
        // 在右子树寻找q和q的最近公共祖先
        int right = lowestCommonAncestor(root.right, o1, o2);
        //p和q分别位于他们最近公共结点的两侧
        // 如果p和q分属两侧，则根节点为最近公共祖先
        if (left != 0 && right != 0) {
            return root.val;
        }
        // 如果左子树有值，则最近公共祖先在左子树，否则，在右子树
        //p或q中有一个为空，返回非空的那个
        if (left == 0) {
            return right;
        }
        // 如果左子树有值，则最近公共祖先在左子树，否则，在右子树
        //p或q中有一个为空，返回非空的那个
        if (right == 0) {
            return left;
        }
        return 0;

    }
}