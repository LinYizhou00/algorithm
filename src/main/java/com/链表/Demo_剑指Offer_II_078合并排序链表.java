package com.链表;

import java.util.PriorityQueue;

/**
 * @Author Lin Yizhou
 * @Date 2023/1/30 10:25
 */
public class Demo_剑指Offer_II_078合并排序链表 {
    public static void main(String[] args) {


    }
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode pro = dummy;
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(  (o1, o2) -> o1.val - o2.val);
        for (ListNode node :lists
             ) {
            if (node!=null) {
                priorityQueue.add(node);
            }
        }
        while (!priorityQueue.isEmpty()){
            ListNode poll = priorityQueue.poll();
            if (poll.next!=null) {
                priorityQueue.add(poll.next);
            }
            pro.next=poll;
            pro= pro.next;
        }
        return dummy.next;

    }
}
