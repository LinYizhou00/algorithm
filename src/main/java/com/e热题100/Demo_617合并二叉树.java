package com.e热题100;


/**
 * @Author Lin Yizhou
 * @Date 2023/2/15 12:46
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

public class Demo_617合并二叉树 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(2);
        t1.left = t2;
        t1.right = t3;
        System.out.println(mergeTrees(t1, t4));

    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return null;
        TreeNode t1;
        TreeNode t2;
        TreeNode treeNode;
        if (root1 == null) {
            int val2 = root2.val;
            treeNode = new TreeNode(val2);
            t1 = mergeTrees(null, root2.left);
            t2 = mergeTrees(null, root2.right);
        } else if (root2 == null) {
            int val1 = root1.val;
            treeNode = new TreeNode(val1);
            t1 = mergeTrees(root1.left, null);
            t2 = mergeTrees(root1.right, null);
        } else {
            treeNode = new TreeNode(root1.val + root2.val);
            t1 = mergeTrees(root1.left, root2.left);
            t2 = mergeTrees(root1.right, root2.right);
        }
        treeNode.left = t1;
        treeNode.right = t2;
        return treeNode;
    }
}
