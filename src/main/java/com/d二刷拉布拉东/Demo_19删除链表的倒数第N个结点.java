package com.d二刷拉布拉东;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/8 23:14
 */
public class Demo_19删除链表的倒数第N个结点 {
    public static void main(String[] args) {
        Demo_19删除链表的倒数第N个结点 demo = new Demo_19删除链表的倒数第N个结点();

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode listNode = demo.removeNthFromEnd(n1, 2);


    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode low = dummy;
        ListNode fast = dummy;
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            low = low.next;
            fast = fast.next;
        }

        low.next = low.next.next;
        return dummy.next;
    }
}
