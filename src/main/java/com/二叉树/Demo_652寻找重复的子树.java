package com.二叉树;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/13 15:31
 */
public class Demo_652寻找重复的子树 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node22 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node44 = new TreeNode(4);
        TreeNode node444 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.left = node22;
        node22.left = node44;
        node3.right = node444;

        System.out.println(findDuplicateSubtrees(node1));
    }

    public static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    static List<TreeNode> res = new ArrayList<>();
    static Map<String, Integer> hashMap = new HashMap<>();

    public static String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String left = traverse(root.left);
        String right = traverse(root.right);
        String s = root.val + "," + left + "," + right;
        Integer orDefault = hashMap.getOrDefault(s, 0);
        if (orDefault == 1) {
            res.add(root);
        }
        hashMap.put(s, orDefault + 1);

        return s;
    }
}
