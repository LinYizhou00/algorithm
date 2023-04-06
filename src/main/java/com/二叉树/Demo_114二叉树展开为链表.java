package com.二叉树;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/11 23:17
 */
public class Demo_114二叉树展开为链表 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        flatten(node1);
        System.out.println(12);

    }

    public static void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode p =root;
        while (p.right!=null){
            p=p.right;
        }
        p.right = right;


    }


}
