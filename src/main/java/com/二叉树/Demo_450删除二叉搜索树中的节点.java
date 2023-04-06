package com.二叉树;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/18 17:44
 */
public class Demo_450删除二叉搜索树中的节点 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(3);
        t1.left = t2;
        t1.right = t3;
        System.out.println(deleteNode(t1, 2));
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val == key) {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode minNode = getMin(root.right);
            deleteNode(root, minNode.val);
            minNode.left = root.left;
            minNode.right = root.right;
            return minNode;
            //TreeNode maxNode = getMax(root.left);
            //deleteNode(root, maxNode.val);
            //maxNode.left = root.left;
            //maxNode.right = root.right;
            //return maxNode;
        }
        if (root.val > key) root.left = deleteNode(root.left, key);
        else root.right = deleteNode(root.right, key);
        return root;

    }

    public static TreeNode getMin(TreeNode root) {
        if (root.left == null) return root;
        return getMin(root.left);
    }

    public static TreeNode getMax(TreeNode root) {
        if (root.right == null) return root;
        return getMax(root.right);
    }
}
