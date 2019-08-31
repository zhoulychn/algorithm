package com.zhoulychn.leetcode;

import com.zhoulychn.common.list.ListNode;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        while (l1 != null) {
            s1.append(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.append(l2.val);
            l2 = l2.next;
        }

        BigDecimal value = new BigDecimal(s1.reverse().toString()).add(new BigDecimal(s2.reverse().toString()));
        String result = new StringBuilder(value.toString()).reverse().toString();
        ListNode node = new ListNode(result.charAt(0) - '0');
        ListNode p = node;
        for (int i = 1; i < result.length(); i++) {
            p.next = new ListNode(result.charAt(i) - '0');
            p = p.next;
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode listNode = new AddTwoNumbers().addTwoNumbers(new ListNode(2).append(4).append(3), new ListNode(5).append(6).append(4));
    }
}
