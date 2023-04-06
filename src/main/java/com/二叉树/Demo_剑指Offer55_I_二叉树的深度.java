package com.二叉树;

/**
 * @Author Lin Yizhou
 * @Date 2023/1/31 1:16
 */
public class Demo_剑指Offer55_I_二叉树的深度 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;

    }
}
