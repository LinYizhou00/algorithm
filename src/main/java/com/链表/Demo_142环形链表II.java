package com.链表;

/**
 * @Author Lin Yizhou
 * @Date 2023/1/30 1:16
 */
public class Demo_142环形链表II {
    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {
        ListNode low = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            low = low.next;
            fast = fast.next.next;
            if (low == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        low = head;
        while (low != fast) {
            low = low.next;
            fast = fast.next;
        }
        return low;
    }
}
