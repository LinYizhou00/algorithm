package com.链表;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/6 11:41
 */
public class Demo_92反转链表II {
    public static void main(String[] args) {

    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (right == left) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode L = pre;
        for (int i = 0; i < left; i++) {
            L = pre;
            pre = pre.next;

        }
        ListNode R = pre;
        ListNode cur = null;
        ListNode nex;
        while (left <= right) {
            nex = pre.next;
            pre.next = cur;
            cur = pre;
            pre = nex;
            left++;
        }
        R.next = pre;
        L.next = cur;
        return dummy.next;

    }
}
