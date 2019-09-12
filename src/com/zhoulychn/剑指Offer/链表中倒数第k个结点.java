package com.zhoulychn.剑指Offer;

import com.zhoulychn.common.list.ListNode;

public class 链表中倒数第k个结点 {

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) return null;
        ListNode pre = head;
        ListNode post = head;

        // 移动k-1步
        for (int i = 0; i < k - 1; i++) {
            // pre下一个为空，说明得不到倒数k的节点，返回null
            if (pre.next == null) return null;
            pre = pre.next;
        }

        while (pre.next != null) {
            pre = pre.next;
            post = post.next;
        }
        return post;
    }
}
