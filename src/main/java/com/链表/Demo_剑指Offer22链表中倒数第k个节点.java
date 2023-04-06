package com.链表;

/**
 * @Author Lin Yizhou
 * @Date 2023/1/30 1:23
 */
public class Demo_剑指Offer22链表中倒数第k个节点 {
    public static void main(String[] args) {

    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode dummy = new ListNode(-1, head);
        ListNode low = dummy;
        ListNode fast = dummy;

        for (int i = 0; i < k + 1; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            low = low.next;
        }
        return low.next;
    }
}
