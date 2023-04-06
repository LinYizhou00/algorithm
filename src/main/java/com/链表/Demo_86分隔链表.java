package com.链表;

/**
 * @Author Lin Yizhou
 * @Date 2023/1/29 18:33
 */
public class Demo_86分隔链表 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(9, new ListNode(4, new ListNode(5)));

        ListNode listNode = partition(node1, 3);
        while (listNode!=null) {
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
    public static ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(-1);
        ListNode psmall = small;
        ListNode big = new ListNode(-1);
        ListNode pbig = big;

        while (true) {
            if (head==null){
                psmall.next=big.next;
                break;
            }
            if (head.val<x){
                psmall.next=new ListNode(head.val);
                psmall=psmall.next;
                head=head.next;
            }else  {
                pbig.next=new ListNode(head.val);
                pbig=pbig.next;
                head=head.next;
            }
        }
        return small.next;



    }
}
