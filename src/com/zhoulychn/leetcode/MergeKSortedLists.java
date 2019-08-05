package com.zhoulychn.leetcode;

import com.zhoulychn.common.list.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*

合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。

示例:

输入:
[
  1->4->5,
  1->3->4,
  2->6
]
输出: 1->1->2->3->4->4->5->6

 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> res = new ArrayList<>();
        for (ListNode node : lists) {
            while (node != null) {
                res.add(node);
                node = node.next;
            }
        }
        res.sort(Comparator.comparingInt(o -> o.val));
        ListNode head = new ListNode(0);
        ListNode p = head;
        for (ListNode item : res) {
            p.next = item;
            p = p.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        new MergeKSortedLists().mergeKLists(new ListNode[]
                {new ListNode(1).append(4).append(5), new ListNode(1).append(3).append(4), new ListNode(2).append(6)});
    }
}
