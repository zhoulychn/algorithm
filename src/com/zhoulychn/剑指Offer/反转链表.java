package com.zhoulychn.剑指Offer;

import com.zhoulychn.common.list.ListNode;

public class 反转链表 {

    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = ReverseList(head.next);
        ListNode p = node;
        head.next = null;
        while (p.next != null) p = p.next;
        p.next = head;
        return node;
    }
}
