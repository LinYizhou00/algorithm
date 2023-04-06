package com.链表;

/**
 * @Author Lin Yizhou
 * @Date 2023/1/30 10:08
 */
public class Demo_剑指Offer_II_021删除链表的倒数第n个结点 {
    public static void main(String[] args) {

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode low = dummy;
        ListNode fast = dummy;
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            low = low.next;
        }
        low.next = low.next.next;
        return dummy.next;
    }
}
