package com.二叉树;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/11 21:42
 */
public class Demo_226翻转二叉树 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        TreeNode treeNode = invertTree(node1);
    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode nodeLeft = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = nodeLeft;
        return root;



        //if (root == null) {
        //    return null;
        //}
        //if (root.left != null || root.right != null) {
        //    TreeNode swap = root.left;
        //    root.left = root.right;
        //    root.right = swap;
        //}
        //invertTree(root.left);
        //invertTree(root.right);
        //return root;
    }

}
