package com.链表;

/**
 * @Author Lin Yizhou
 * @Date 2023/1/30 1:34
 */
public class Demo_剑指Offer25合并两个排序的链表 {
    public static void main(String[] args) {

        ListNode node1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode node2 = new ListNode(2, new ListNode(9, new ListNode(12)));
        ListNode listNode = mergeTwoLists(node1, node2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = (l1 == null ? l2 : l1);
        return dummy.next;


    }
}
