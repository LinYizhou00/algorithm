package com.d二刷拉布拉东;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/9 19:10
 */
public class Demo_83删除排序链表中的重复元素 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n11 = new ListNode(1);
        ListNode n2 = new ListNode(2);

        n1.next = n11;
        n11.next = n2;
        Demo_83删除排序链表中的重复元素 demo = new Demo_83删除排序链表中的重复元素();
        ListNode listNode = demo.deleteDuplicates(n1);

    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode index = head;
        ListNode point = head;
        while (point != null) {
            if (point.val != index.val) {
                index.next = point;
                index = index.next;
            } else {
                point = point.next;
            }
        }
        if (index != null) {
            index.next = null;
        }
        return head;
    }
}
