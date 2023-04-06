package com.缓存淘汰算法;

import java.util.*;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/26 20:09
 */
class Node {
    int key, value;
    Node pre, next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class DoubleList {
    Node head, tail;
    int size;


    public DoubleList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        tail.pre = head;
        head.next = tail;
        size = 0;
    }

    public void addLast(Node x) {
        size++;
        Node swap = tail.pre;
        swap.next = x;
        x.pre = swap;
        x.next = tail;
        tail.pre = x;
    }


    public void removeLast() {
        size--;
        Node pro = tail.pre.pre;
        pro.next = tail;
        tail.pre = pro;
    }

    public void remove(Node x) {
        size--;
        x.pre.next = x.next;
        x.next.pre = x.pre;
    }

    public int getSize() {
        return size;
    }

    public Node removeFirst() {
        size--;
        Node rem = head.next;
        Node nex = head.next.next;
        head.next = nex;
        nex.pre = head;
        return rem;

    }
}

public class Demo_146LRU缓存 {
    public static void main(String[] args) {

    }

    HashMap<Integer, Node> hashMap;
    DoubleList cache;
    int cap;


    private void makeRecently(int key) {
        Node x = hashMap.get(key);
        cache.remove(x);
        cache.addLast(x);
    }

    private void addRecently(int key, int val) {
        Node x = new Node(key, val);
        cache.addLast(x);
        hashMap.put(key, x);
    }

    private void deleteKey(int key) {
        Node x = hashMap.get(key);
        cache.remove(x);
        hashMap.remove(key);
    }

    private void removeLeastRecently() {
        Node deletedNode = cache.removeFirst();
        int deletedKey = deletedNode.key;
        hashMap.remove(deletedKey);
    }

    public Demo_146LRU缓存(int capacity) {
        cap = capacity;
        hashMap = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key) {
        if (!hashMap.containsKey(key)) return -1;
        makeRecently(key);
        return hashMap.get(key).value;
    }

    public void put(int key, int value) {
        if (hashMap.containsKey(key)) {
            deleteKey(key);
            addRecently(key, value);
        } else {
            if (cache.size == cap) removeLeastRecently();
            addRecently(key, value);
        }
    }
}
