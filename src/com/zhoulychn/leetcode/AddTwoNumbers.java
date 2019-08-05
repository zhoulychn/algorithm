package com.zhoulychn.leetcode;

import com.zhoulychn.common.list.ListNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/*

给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807

 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        LinkedList<ListNode> p = new LinkedList<>();
        LinkedList<ListNode> q = new LinkedList<>();
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                p.addFirst(l1);
                l1 = l1.next;
            } else p.addFirst(new ListNode(0));
            if (l2 != null) {
                q.addFirst(l2);
                l2 = l2.next;
            } else q.addFirst(new ListNode(0));

        }
        ListNode head = new ListNode(0);
        ListNode node = head;
        int k = 0;
        for (int i = p.size() - 1; i >= 0; i--) {
            int v1 = p.get(i).val;
            int v2 = q.get(i).val;
            node.next = new ListNode((v1 + v2 + k) % 10);
            node = node.next;
            k = v1 + v2 + k >= 10 ? 1 : 0;
        }
        if (k == 1) {
            node.next = new ListNode(1);
            node = node.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode listNode = new AddTwoNumbers().addTwoNumbers(new ListNode(2).append(4).append(3), new ListNode(5).append(6).append(4));
    }
}
