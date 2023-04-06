package com.链表;

/**
 * @Author Lin Yizhou
 * @Date 2023/1/30 10:00
 */
public class Demo_剑指Offer52两个链表的第一个公共节点 {
    public static void main(String[] args) {

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode proA = headA;
        ListNode proB = headB;

        while (!(proA==null&&proB==null)) {
            if (proA==proB){
                return proA;
            }
            if (proA==null){
                proA=headB;
            }else {
                proA=proA.next;
            }

            if (proB==null){
                proB=headA;
            }else {
                proB=proB.next;
            }

        }
        return proA;
    }

}
