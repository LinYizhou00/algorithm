package com.d二刷拉布拉东;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/9 19:55
 */
public class Demo_543二叉树的直径 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        Demo_543二叉树的直径 demo = new Demo_543二叉树的直径();
        int i = demo.diameterOfBinaryTree(t1);
        System.out.println(i);

    }

    int max = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        depth(root);
        return max-1;
    }

    public int depth(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        int m = left + right + 1;
        max = Math.max(max, m);
        return Math.max(left, right) + 1;
    }
}
