package com.二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/11 22:09
 */
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class Demo_116填充每个节点的下一个右侧节点指针 {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.left = node2;
        node1.right = node3;
        Node connect = connect1(node1);

    }

    public static Node connect3(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }
        connect3(root.left);
        connect3(root.right);
        return root;
    }

    //先序遍历三叉树
    public static Node connect1(Node root) {
        if (root == null) return null;
        traverse(root.left, root.right);
        return root;
    }

    public static void traverse(Node left, Node right) {
        if (left == null) return;
        left.next = right;
        traverse(left.left, left.right);
        traverse(left.right, right.left);
        traverse(right.left, right.right);
    }

    //层序遍历
    public static Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                if (poll.left != null) {
                    queue.add(poll.left);
                }
                if (poll.right != null) {
                    queue.add(poll.right);
                }
                if (i != size - 1) {
                    poll.next = queue.peek();
                }
            }
        }
        return root;
    }
}
