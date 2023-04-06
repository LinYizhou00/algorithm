package com.链表;

/**
 * @Author Lin Yizhou
 * @Date 2023/1/30 10:22
 */
public class Demo_剑指Offer_II_023两个链表的第一个重合节点 {
    public static void main(String[] args) {

    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode proA = headA,proB = headB;
        while (proA!=proB){
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
