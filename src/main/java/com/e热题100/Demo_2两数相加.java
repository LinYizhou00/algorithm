package com.e热题100;


/**
 * @Author Lin Yizhou
 * @Date 2023/2/14 22:34
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Demo_2两数相加 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(9)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(9))));
        ListNode x = addTwoNumbers(l1, l2);
        while (x != null) {
            System.out.println(x.val);
            x = x.next;
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode pro = dummy;
        while (!(l1 == null && l2 == null)) {
            int a = 0;
            int b = 0;
            if (l1 != null) {
                a = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                b = l2.val;
                l2 = l2.next;
            }
            int n = a + b;
            if (pro.next != null) n += pro.next.val;
            if (n < 10) {
                if (pro.next != null) pro.next.val = n;
                else pro.next = new ListNode(n);
                pro.next.val = n;
            } else {
                int ze = n - 10;
                if (pro.next != null) pro.next.val = ze;
                else pro.next = new ListNode(ze);
                pro.next.next = new ListNode(1);
            }
            pro = pro.next;
        }
        return dummy.next;
    }
}
