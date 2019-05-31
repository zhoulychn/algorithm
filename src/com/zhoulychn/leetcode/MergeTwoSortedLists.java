package com.zhoulychn.leetcode;


import com.zhoulychn.BaseBean.List.ListNode;


/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */

public class MergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode cur = result;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }

        if (l1 != null) {
            cur.next = l1;
        } else {
            cur.next = l2;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode ls1 = new ListNode(1).append(3).append(4);
        ListNode ls2 = new ListNode(1).append(2).append(4);
        System.out.println(mergeTwoLists(ls1,ls2));
    }
}
