package com.d二刷拉布拉东;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/9 0:58
 */
public class Demo_86分隔链表 {
    public static void main(String[] args) {
        Demo_86分隔链表 demo = new Demo_86分隔链表();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n22= new ListNode(2);
        n1.next = n4;
        n4.next = n3;
        n3.next = n2;
        n2.next = n5;
        n5.next = n22;
        ListNode partition = demo.partition(n1, 3);

    }

    public ListNode partition(ListNode head, int x) {
        ListNode minDummy = new ListNode(-1);
        ListNode minPro = minDummy;
        ListNode maxDummy = new ListNode(-1);
        ListNode  maxPro= maxDummy;
        while (head!=null) {
            if (head.val<x){
                minPro.next=head;
                minPro=minPro.next;
                head=head.next;
                minPro.next=null;
            }else {
                maxPro.next=head;
                maxPro=maxPro.next;
                head=head.next;
                maxPro.next=null;
            }
        }
        minPro.next=maxDummy.next;
        return minDummy.next;

    }
}
