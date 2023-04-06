package com.链表;

/**
 * @Author Lin Yizhou
 * @Date 2023/1/30 1:12
 */
public class Demo_141环形链表 {
    public static void main(String[] args) {

    }

    public static boolean hasCycle(ListNode head) {
        ListNode low = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            low = low.next;
            fast = fast.next.next;
            if (fast == low) {
                return true;
            }
        }
        return false;


    }
}
