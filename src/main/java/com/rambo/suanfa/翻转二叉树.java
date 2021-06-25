package com.rambo.suanfa;

/**
 *
 *  4
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
        TreeNodes node1 = new TreeNodes(4, null, null);
        TreeNodes node2 = new TreeNodes(2, null, null);
        TreeNodes node3 = new TreeNodes(7, null, null);
        TreeNodes node4 = new TreeNodes(1, null, null);
        TreeNodes node5 = new TreeNodes(3, null, null);
        TreeNodes node6 = new TreeNodes(6, null, null);
        TreeNodes node7 = new TreeNodes(9, null, null);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        System.out.println("反转前：" + node1.toString());
        TreeNodes treeNodes = invertTree(node1);
        System.out.println("反转后：" + treeNodes.toString());
    }

    public static TreeNodes invertTree(TreeNodes root) {
        //跳出递归条件是节点为空或者左子节点为空并且右子节点为空
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        //翻转左子树
        TreeNodes left = invertTree(root.left);
        //翻转右子树
        TreeNodes right = invertTree(root.right);
        //左右子树交换位置~
        root.left = right;
        root.right = left;
        return root;

    }
}

@Data
class TreeNodes {
    int val;
    TreeNodes left;
    TreeNodes right;


    public TreeNodes(int val, TreeNodes left, TreeNodes right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
}
