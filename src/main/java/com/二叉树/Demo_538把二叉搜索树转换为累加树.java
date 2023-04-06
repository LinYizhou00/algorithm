package com.二叉树;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/17 18:43
 */
public class Demo_538把二叉搜索树转换为累加树 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(5);
        TreeNode t4 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        t2.right = t4;
        System.out.println(convertBST(t1));
    }

    public static TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;

    }

    static int sum = 0;

    public static void traverse(TreeNode root) {
        if (root == null) return;
        traverse(root.right);
        root.val = sum += root.val;
        traverse(root.left);

    }

}
