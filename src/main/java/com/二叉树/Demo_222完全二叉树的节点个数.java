package com.二叉树;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/19 19:43
 */
public class Demo_222完全二叉树的节点个数 {
    public static void main(String[] args) {

    }

    public static int countNodes(TreeNode root) {
        TreeNode l = root, r = root;
        int hl = 0, hr = 0;
        while (l != null) {
            l = l.left;
            hl++;
        }
        while (r != null) {
            r = r.right;
            hr++;
        }
        if (hl == hr) return (int) Math.pow(2, hr) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
