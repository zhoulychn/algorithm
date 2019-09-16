package com.zhoulychn.剑指Offer;

import com.zhoulychn.common.list.ListNode;

import java.util.HashSet;

public class 环的入口节点 {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        HashSet<ListNode> set = new HashSet<>();
        while (pHead != null) {
            if (set.contains(pHead)) return pHead;
            set.add(pHead);
            pHead = pHead.next;
        }
        return null;
    }
}
