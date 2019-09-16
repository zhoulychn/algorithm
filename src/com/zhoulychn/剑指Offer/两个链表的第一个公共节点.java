package com.zhoulychn.剑指Offer;

import com.zhoulychn.common.list.ListNode;

import java.util.HashSet;

public class 两个链表的第一个公共节点 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        HashSet<ListNode> set = new HashSet<>();
        while (pHead1 != null) {
            set.add(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            if (set.contains(pHead2)) return pHead2;
            pHead2 = pHead2.next;
        }
        return null;
    }

}
