package com.链表;

/**
 * @Author Lin Yizhou
 * @Date 2023/2/6 11:48
 */
public class Demo_206反转链表 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode reverse = reverse(node1);
        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }

    //反转链表
    public static ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode nex;
        while (head != null) {
            nex = head.next;
            head.next = pre;
            pre = head;
            head = nex;
        }
        return pre;


    }

    //反转链表的一部分
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) return reverseN(head, n);
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }

    //反转链表前 N 个节点,将链表的前 n 个节点反转（n <= 链表长度）
    static ListNode node;

    public static ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            node = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = node;
        return last;
    }

    //递归反转整个链表
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;

    }

}
