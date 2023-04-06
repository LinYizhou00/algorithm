package com.二叉树;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/17 16:32
 */
public class Demo_230二叉搜索树中第K小的元素 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        t2.right = t4;
        System.out.println(kthSmallest(t1, 1));

    }

    static int rank = 0;
    static int res = 0;

    public static int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    public static void traverse(TreeNode root, int k) {
        if (root == null) return;
        traverse(root.left, k);
        rank++;
        if (rank == k) res = root.val;
        traverse(root.right, k);
    }
}
