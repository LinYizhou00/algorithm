package com.链表;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/29 17:31
 */
public class Demo_剑指Offer_II_027回文链表 {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode re = re(fast.next == null ? slow : slow.next);
        while (re != null) {
            if (head.val != re.val) {
                return false;
            } else {
                head = head.next;
                re = re.next;
            }
        }
        return true;
    }

    public ListNode re(ListNode head) {
        ListNode nex;
        ListNode pro = null;
        while (head != null) {
            nex = head.next;
            head.next = pro;
            pro = head;
            head = nex;
        }
        return pro;
    }
}
