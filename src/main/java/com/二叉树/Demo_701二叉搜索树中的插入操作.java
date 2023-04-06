package com.二叉树;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/18 17:47
 */
public class Demo_701二叉搜索树中的插入操作 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        System.out.println(insertIntoBST(t1, 4));
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {

        if (root == null) return new TreeNode(val);
        if (root.val < val) root.right = insertIntoBST(root.right, val);
        else root.left = insertIntoBST(root.left, val);
        return root;

    }
}
