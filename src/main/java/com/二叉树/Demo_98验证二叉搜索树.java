package com.二叉树;



/**
 * @Author Lin Yizhou
 * @Date 2023/2/18 9:03
 */
public class Demo_98验证二叉搜索树 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        System.out.println(isValidBST(t1));


    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);

    }

    public static boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) return true;
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
}

