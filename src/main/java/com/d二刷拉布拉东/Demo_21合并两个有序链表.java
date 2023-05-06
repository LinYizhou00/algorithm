package com.d二刷拉布拉东;

/**
 * @Author Lin Yizhou
 * @Date 2023/4/8 23:39
 */
public class Demo_21合并两个有序链表 {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode pro = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                pro.next = list2;
                pro = pro.next;
                list2 = list2.next;
            } else {
                pro.next = list1;
                pro = pro.next;
                list1 = list1.next;
            }
        }
        if (list1 == null && list2 == null) return dummy.next;
        pro.next = list1 == null ? list2 : list1;


        return dummy.next;
    }
}
