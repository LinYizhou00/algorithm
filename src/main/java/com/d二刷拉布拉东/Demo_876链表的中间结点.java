package com.d二刷拉布拉东;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/9 14:31
 */
public class Demo_876链表的中间结点 {
    public static void main(String[] args) {
        Demo_876链表的中间结点 demo = new Demo_876链表的中间结点();

    }

    public ListNode middleNode(ListNode head) {
        ListNode low = head;
        ListNode fast = head;

        while (fast!=null&&fast.next!=null) {
            low=low.next;
            fast=fast.next.next;
        }

        return low;

    }
}
