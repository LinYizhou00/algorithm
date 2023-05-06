package com.d二刷拉布拉东;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/8 23:46
 */
public class Demo_23合并K个升序链表 {
    public static void main(String[] args) {
        Demo_23合并K个升序链表 demo = new Demo_23合并K个升序链表();
    }

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode pro = dummy;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode list : lists) {
            if (list != null) {
                priorityQueue.offer(list);
            }
        }
        while (!priorityQueue.isEmpty()) {
            ListNode poll = priorityQueue.poll();
            if (poll.next != null) {
                priorityQueue.offer(poll.next);
            }
            pro.next = poll;
            pro = pro.next;
        }
        return dummy.next;
    }
}
