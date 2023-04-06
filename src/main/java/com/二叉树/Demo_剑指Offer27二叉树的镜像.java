package com.二叉树;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/12 1:30
 */
public class Demo_剑指Offer27二叉树的镜像 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode nodeLeft = mirrorTree(root.left);
        root.left = mirrorTree(root.right);
        root.right = nodeLeft;
        return root;
    }

}
