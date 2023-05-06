package com.d二刷拉布拉东;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/29 16:18
 */
public class Demo_92反转链表II {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        System.out.println(new Demo_92反转链表II().reverseBetween(
                n1, 2, 4
        ));


    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
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
