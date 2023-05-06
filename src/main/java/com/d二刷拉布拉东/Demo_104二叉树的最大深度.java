package com.d二刷拉布拉东;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/9 19:29
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

public class Demo_104二叉树的最大深度 {
    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        return root==null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
