package com.链表;

/**
 * @Author Lin Yizhou
 * @Date 2023/1/29 14:11
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

public class Demo_21合并两个有序链表 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode node2 = new ListNode(2, new ListNode(9, new ListNode(12)));

        ListNode listNode = mergeTwoLists(node1, node2);
        while (listNode!=null) {
            System.out.println(listNode.val);
            listNode=listNode.next;
        }


    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node = new ListNode(-1);
        ListNode p = node;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                p.next = new ListNode(list2.val);
                p=p.next;
                list2 = list2.next;
            } else {
                p.next = new ListNode(list1.val);
                p=p.next;

                list1 = list1.next;
            }
        }
        if (list1 == null) {
            p.next = list2;
        }
        if (list2 == null) {
            p.next = list1;
        }
        return node.next;


    }
}
