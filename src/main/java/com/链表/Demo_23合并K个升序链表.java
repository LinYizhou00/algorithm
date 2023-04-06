package com.链表;

import java.util.*;

/**
 * @Author Lin Yizhou
 * @Date 2023/1/29 18:50
 */
public class Demo_23合并K个升序链表 {
    public static void main(String[] args) {
        ListNode listNode = mergeKLists(new ListNode[]{
                new ListNode(1), new ListNode(8)
        });
        System.out.println(listNode.val);

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(
                lists.length, (a, b) -> (a.val - b.val)
        );
        for (ListNode head : lists) {
            if (head != null) {
                priorityQueue.add(head);
            }
        }
        while (!priorityQueue.isEmpty()) {
            ListNode poll = priorityQueue.poll();
            p.next = poll;
            if (poll.next != null) {
                priorityQueue.add(poll.next);
            }
            p = p.next;
        }
        return dummy.next;
    }
}
