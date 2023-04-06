package com.二叉树;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/12 23:10
 */
public class Demo_297二叉树的序列化与反序列化 {
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        String data = serialize2(node1);
        System.out.println(data);
        TreeNode x = deserialize2(data);

        System.out.println(x);

    }

    //层序
    public static String serialize2(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll == null) {
                    sb.append("#").append(",");
                    continue;
                } else {
                    sb.append(poll.val).append(",");
                }
                queue.offer(poll.left);
                queue.offer(poll.right);
            }
        }
        return sb.toString();


    }


    public static TreeNode deserialize2(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] nodes = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        String node = nodes[0];
        if ("#".equals(node)) return null;
        TreeNode e = new TreeNode(Integer.parseInt(node));
        queue.offer(e);
        for (int i = 1; i < nodes.length; i++) {
            TreeNode poll = queue.poll();
            String nodeLeft = nodes[i++];
            if ("#".equals(nodeLeft)) {
                poll.left = null;
            } else {
                TreeNode left = new TreeNode(Integer.parseInt(nodeLeft));
                poll.left = left;
                queue.offer(left);
            }
            String nodeRight = nodes[i];
            if ("#".equals(nodeRight)) {
                poll.right = null;
            } else {
                TreeNode right = new TreeNode(Integer.parseInt(nodeRight));
                poll.right = right;
                queue.offer(right);
            }
        }
        return e;
    }


    //后序
    public static String serialize1(TreeNode root) {
        StringBuilder sb1 = new StringBuilder();
        serialize1(root, sb1);
        return sb1.toString();

    }

    public static void serialize1(TreeNode root, StringBuilder sb1) {
        if (root == null) {
            sb1.append("#").append(",");
            return;
        }
        serialize1(root.left, sb1);
        serialize1(root.right, sb1);
        sb1.append(root.val).append(",");
    }


    public static TreeNode deserialize1(String data) {
        LinkedList<String> list = Arrays.stream(data.split(",")).collect(Collectors.toCollection(LinkedList::new));
        return des1(list);

    }

    public static TreeNode des1(LinkedList<String> list) {
        if (list.isEmpty()) {
            return null;
        }
        String s = list.removeLast();
        if ("#".equals(s)) {
            return null;
        }
        TreeNode treeNode = new TreeNode(Integer.parseInt(s));
        treeNode.right = des1(list);
        treeNode.left = des1(list);
        return treeNode;
    }

    //先序

    public static String serialize(TreeNode root) {
        StringBuilder sb  = new StringBuilder();
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
