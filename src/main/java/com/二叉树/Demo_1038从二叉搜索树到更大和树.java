package com.二叉树;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/17 19:26
 */
public class Demo_1038从二叉搜索树到更大和树 {
    public static void main(String[] args) {

    }

    public TreeNode bstToGst(TreeNode root) {
        traverse(root);
        return root;
    }
    int sum = 0;
    public void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.right);
        root.val = sum += root.val;
        traverse(root.left);
    }
}
