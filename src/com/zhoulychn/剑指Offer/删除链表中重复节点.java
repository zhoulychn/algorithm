package com.zhoulychn.剑指Offer;

import com.zhoulychn.common.list.ListNode;

public class 删除链表中重复节点 {

    public ListNode deleteDuplication(ListNode pHead) {

        // 如果结点或者下一个为null，没有重复，返回当前结点
        if (pHead == null || pHead.next == null) return pHead;

        // 当前结点和下一个相等，都需要删除，
        if (pHead.val == pHead.next.val) {
            ListNode node = pHead.next;

            // 找到最后一个不相同的结点，递归调用后返回
            while (node != null && node.val == pHead.val) node = node.next;
            return deleteDuplication(node);
        } else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }

    public static void main(String[] args) {
        new 删除链表中重复节点().deleteDuplication(new ListNode(1, 1, 1, 1, 1, 1, 1));
    }
}
