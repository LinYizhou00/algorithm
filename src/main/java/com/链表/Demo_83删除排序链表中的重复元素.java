package com.链表;

/**
 * @Author Lin Yizhou
 * @Date 2023/1/30 11:16
 */
public class Demo_83删除排序链表中的重复元素 {
    public static void main(String[] args) {

    }
    public static ListNode deleteDuplicates(ListNode head) {
        if (head==null){
            return null;
        }
        ListNode slow  = head;
        ListNode fast   = head;
        while (fast!=null){
            if (slow.val!=fast.val){
                slow.next=fast;
                slow=slow.next;
            }
            fast =fast.next;
        }
        slow.next=null;
        return head;

    }
}
