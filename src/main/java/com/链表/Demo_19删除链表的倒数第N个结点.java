package com.链表;

/**
 * @Author Lin Yizhou
 * @Date 2023/1/29 21:35
 */
public class Demo_19删除链表的倒数第N个结点 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode listNode = removeNthFromEnd(node1, 3);
        System.out.println(listNode.val);

    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1, head);
        ListNode top = dummy;
        ListNode last = dummy;

        for (int i = 0; i < n+1; i++) {
            last=last.next;
        }
        while (last != null) {
            top=top.next;
            last=last.next;
        }
        top.next=top.next.next;
        return dummy.next;
    }

}
