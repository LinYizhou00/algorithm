package com.e热题100;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/16 1:14
 */
public class Demo_234回文链表 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(0);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println(isPalindrome(n1));

    }

    static boolean isCon = true;
    static ListNode pro;
    static ListNode fast;

    public static boolean isPalindrome(ListNode head) {
        ListNode midNode = getMidNode(head);
        if (head.next == null) return true;
        if (fast == null) pro = midNode.next;
        else pro = midNode.next.next;
        getValue(head, midNode);
        return isCon;
    }

    public static void getValue(ListNode head, ListNode midNode) {
        if (head == midNode.next) return;
        getValue(head.next, midNode);
        if (!isCon) return;
        if (head.val != pro.val) {
            isCon = false;
        } else {
            pro = pro.next;
        }
    }

    public static ListNode getMidNode(ListNode head) {
        ListNode low = head;
        fast = head;
        ListNode res = null;
        while (fast != null && fast.next != null) {
            res = low;
            low = low.next;
            fast = fast.next.next;
        }
        return res;
    }
}
