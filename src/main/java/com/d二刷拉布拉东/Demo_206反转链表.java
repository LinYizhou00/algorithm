package com.d二刷拉布拉东;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/29 15:47
 */
public class Demo_206反转链表 {
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
