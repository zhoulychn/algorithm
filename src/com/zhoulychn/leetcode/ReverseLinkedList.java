package com.zhoulychn.leetcode;

import com.zhoulychn.common.list.ListNode;

/*

反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode node = reverseList(head.next);

        ListNode p = node;

        head.next = null;
        while (p.next != null) {
            p = p.next;
        }
        p.next = head;
        return node;
    }

    public static void main(String[] args) {
        new ReverseLinkedList().reverseList(new ListNode(1).append(2).append(3).append(4).append(5));
    }
}
