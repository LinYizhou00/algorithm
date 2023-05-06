package com.d二刷拉布拉东;


/**
 * @Author Lin Yizhou
 * @Date 2023/4/8 21:25
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Demo_141环形链表 {
    public static void main(String[] args) {
        ListNode n3 = new ListNode(3);
        ListNode n2= new ListNode(2);
        ListNode n0 = new ListNode(0);
        ListNode n4 = new ListNode(4);
        n3.next=n2;
        n2.next=n0;
        n0.next=n4;
        //n4.next=n2;
        System.out.println(hasCycle(n3));

    }

    public static boolean hasCycle(ListNode head) {
        ListNode low = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            low = low.next;
            fast = fast.next.next;
            if (low == fast) return true;

        }
        return false;
    }

}
