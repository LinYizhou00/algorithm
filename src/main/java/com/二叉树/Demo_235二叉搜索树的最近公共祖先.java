package com.二叉树;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/19 17:37
 */
public class Demo_235二叉搜索树的最近公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        int min = Math.min(p.val, q.val);
        int max = Math.max(p.val, q.val);
        TreeNode node = null;
        if (root.val < min) node = lowestCommonAncestor(root.right, p, q);
        if (root.val > max) node = lowestCommonAncestor(root.left, p, q);
        return node == null ? root : node;
    }
}
