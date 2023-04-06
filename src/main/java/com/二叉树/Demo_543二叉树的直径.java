package com.二叉树;

/**
 * @Author Lin Yizhou
 * @Date 2023/1/26 11:59
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Demo_543二叉树的直径 {
    public static void main(String[] args) {

    }

    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
         maxDepth(root);
         return maxDiameter;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        int max = leftMax + rightMax;
        maxDiameter = Math.max(max, maxDiameter);
        return 1+Math.max(leftMax, rightMax);
    }
}
