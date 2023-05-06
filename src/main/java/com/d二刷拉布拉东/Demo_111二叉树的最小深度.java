package com.d二刷拉布拉东;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/11 23:29
 */
public class Demo_111二叉树的最小深度 {
    public static void main(String[] args) {
        TreeNode t3 = new TreeNode(3);
        TreeNode t9 = new TreeNode(9);
        TreeNode t20 = new TreeNode(20);
        TreeNode t15 = new TreeNode(15);
        TreeNode t7 = new TreeNode(7);
        t3.left = t9;
        t3.right = t20;
        t20.left = t15;
        t20.right = t7;
        System.out.println(new Demo_111二叉树的最小深度().minDepth(t3));

    }

    public int minDepth(TreeNode root) {
        int res = 0;
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) queue.offer(poll.left);
                if (poll.right != null) queue.offer(poll.right);
                if (poll.left == null && poll.right == null) return res;
            }
        }
        return res;
    }


}
