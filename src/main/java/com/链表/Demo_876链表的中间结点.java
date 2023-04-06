package com.链表;

/**
 * @Author Lin Yizhou
 * @Date 2023/1/29 22:43
 */
public class Demo_876链表的中间结点 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, new ListNode(4));
        System.out.println(middleNode(node1).val);

    }

    public static ListNode middleNode(ListNode head) {
        ListNode quickly = head, mid = head;
        while (quickly != null && quickly.next != null) {
            mid = mid.next;
            quickly = quickly.next.next;

        }
        return mid;

    }

}
