package com.d二刷拉布拉东;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/8 22:13
 */
public class Demo_142环形链表II {
    public static void main(String[] args) {
        Demo_142环形链表II demo = new Demo_142环形链表II();
        ListNode n3 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n0 = new ListNode(0);
        ListNode n4 = new ListNode(4);
        n3.next = n2;
        n2.next = n0;
        n0.next = n4;
        n4.next = n2;
        System.out.println(demo.detectCycle(n3).val);
    }

    public ListNode detectCycle(ListNode head) {
        if (head==null||head.next==null) return null;
        ListNode low = head;
        ListNode fast = head;

        while ( fast!=null && fast.next!=null    ) {
            fast = fast.next.next;
            low = low.next;
            if (fast==low)break;

        }
        if (fast==null||fast.next==null) return null;
        fast = head;
        while (!(fast == low)) {
            fast = fast.next;
            low = low.next;
        }
        return fast;
    }
}
