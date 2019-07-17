package com.zhoulychn.lintCode;


import com.zhoulychn.common.list.ListNode;

//计算链表中有多少个节点.

public class Num_466 {

    public int countNodes(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
