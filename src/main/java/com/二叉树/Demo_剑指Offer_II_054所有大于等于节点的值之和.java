package com.二叉树;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/17 19:29
 */
public class Demo_剑指Offer_II_054所有大于等于节点的值之和 {
    public static void main(String[] args) {

    }

    public TreeNode convertBST(TreeNode root) {
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
