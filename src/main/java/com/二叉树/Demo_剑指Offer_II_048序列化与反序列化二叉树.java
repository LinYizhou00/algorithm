package com.二叉树;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/13 15:29
 */
public class Demo_剑指Offer_II_048序列化与反序列化二叉树 {
    public static void main(String[] args) {

    }

    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    public static void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#").append(",");
            return;
        }
        sb.append(root.val).append(",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }


    public static TreeNode deserialize(String data) {
        String[] split = data.split(",");
        LinkedList<String> list = Arrays.stream(split).collect(Collectors.toCollection(LinkedList::new));
        return des(list);
    }

    public static TreeNode des(LinkedList<String> list) {
        if (list.isEmpty()) return null;
        String s = list.pollFirst();
        if ("#".equals(s)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = des(list);
        root.right = des(list);
        return root;
    }
}
