package com.链表;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/29 16:59
 */
public class Demo_剑指Offer_II_024反转链表 {
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode nex = head.next;
            head.next = pre;
            pre = head;
            head = nex;
        }
        return pre;
    }
}
