package com.链表;

/**
 * @Author Lin Yizhou
 * @Date 2023/1/30 10:16
 */
public class Demo_剑指Offer_II_022链表中环的入口节点 {
    public static void main(String[] args) {

    }

    public static ListNode detectCycle(ListNode head) {
        ListNode low = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            low = low.next;
            if (fast == low) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        low = head;
        while (fast != low) {
            fast = fast.next;
            low = low.next;
        }
        return low;

    }
}
