package com.zhoulychn.剑指Offer;

import com.zhoulychn.common.list.ListNode;

public class 合并两个排序链表 {

    public ListNode Merge(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(1);
        ListNode p = head;
        while (list1 != null || list2 != null) {
            if (list1 == null || (list2 != null && list2.val < list1.val)) {
                p.next = list2;
                p = p.next;
                list2 = list2.next;
            } else {
                p.next = list1;
                p = p.next;
                list1 = list1.next;
            }
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode merge = new 合并两个排序链表().Merge(new ListNode(1).append(3).append(5), new ListNode(2).append(4).append(6));
    }
}
