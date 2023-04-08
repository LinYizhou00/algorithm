package com.f剑指offer;

import java.util.ArrayList;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/7 10:08
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Demo_剑指Offer06从尾到头打印链表 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3)));
        reversePrint(listNode);
    }

    static ArrayList<Integer> nums = new ArrayList<Integer>();

    public static int[] reversePrint(ListNode head) {
        toPrint(head);
        int[] num = new int[nums.size()];
        for (int i = 0; i < num.length; i++) {
            num[i] = nums.get(i);
        }
        return num;

    }

    public static void toPrint(ListNode head) {
        if (head == null) return;
        toPrint(head.next);
        nums.add(head.val);
    }
}
