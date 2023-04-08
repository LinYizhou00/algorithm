package com.f剑指offer;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/7 10:37
 */
public class Demo_剑指Offer24反转链表 {
    public static void main(String[] args) {

    }

    public static ListNode reverseList(ListNode head) {
        ListNode cur = head,pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next=pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
