package com.f剑指offer;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/7 10:25
 */
public class Demo_剑指Offer18删除链表的节点 {
    public static void main(String[] args) {
        ListNode node = new ListNode(4, new ListNode(5, new ListNode(1, new ListNode(9, null))));
        deleteNode(node,9);

    }
    public static ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(-1, head);
        ListNode top =dummy;

        while (true){
            if (top.next.val==val) {
                top.next=top.next.next;
                break;
            }
            top = top.next;
        }
        return dummy.next;


    }
}
