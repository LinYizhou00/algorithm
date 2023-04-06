package com.二叉树;

/**
 * @Author Lin Yizhou
 * @Date 2023/1/30 23:09
 */
public class Demo_104二叉树的最大深度 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left=node2;
        node1.right=node3;
        node2.left=node4;
        System.out.println(maxDepth(node1));

    }
    public static int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right)+1;
    }
}
