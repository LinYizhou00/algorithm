package com.二叉树;

import java.util.Arrays;
import java.util.function.IntConsumer;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/12 9:26
 */
public class Demo_654最大二叉树 {
    public static void main(String[] args) {
        System.out.println(constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5}));

    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    public static TreeNode build(int[] nums, int start, int end) {
        if (end - start < 0) return null;
        if (end - start == 0) return new TreeNode(nums[start]);
        int max = nums[start];
        int index = start;
        for (int i = start + 1; i < end + 1; i++) {
            if (nums[i] > max) {
                index = i;
                max = nums[i];
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = build(nums, start, index-1);
        root.right = build(nums, index + 1, end);
        return root;

    }


}
