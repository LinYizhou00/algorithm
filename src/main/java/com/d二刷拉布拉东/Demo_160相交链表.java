package com.d二刷拉布拉东;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/8 22:55
 */
public class Demo_160相交链表 {
    public static void main(String[] args) {
        Demo_160相交链表 demo = new Demo_160相交链表();


    }


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode preA = headA;
        ListNode preB = headB;

        while (headA != headB) {
            if (headA == null) {
                headA = preB;
            } else {
                headA = headA.next;
            }
            if (headB == null) {
                headB = preA;

            } else {
                headB = headB.next;
            }
        }
        return headA;
    }
}
