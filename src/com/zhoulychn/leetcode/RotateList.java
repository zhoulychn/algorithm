package com.zhoulychn.leetcode;

import com.zhoulychn.common.list.ListNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*

给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: 1->2->3->4->5->NULL, k = 2
输出: 4->5->1->2->3->NULL
解释:
向右旋转 1 步: 5->1->2->3->4->NULL
向右旋转 2 步: 4->5->1->2->3->NULL
示例 2:

输入: 0->1->2->NULL, k = 4
输出: 2->0->1->NULL
解释:
向右旋转 1 步: 2->0->1->NULL
向右旋转 2 步: 1->2->0->NULL
向右旋转 3 步: 0->1->2->NULL
向右旋转 4 步: 2->0->1->NULL

 */
public class RotateList {

    // 先遍历一遍，找到链表长度，末尾节点和头部节点相连，然后找到断开的head和tail
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0) return head;
        if (head == null || head.next == null) return head;
        List<ListNode> list = new LinkedList<>();
        ListNode tail = head;
        while (true) {
            list.add(tail);
            tail = tail.next;
            if (tail.next == null) {
                list.add(tail);
                break;
            }
        }


        if (k % list.size() == 0) return head;
        tail.next = head;

        // 净移动次数
        k = k % list.size();

        // 最后的索引 - k为最后一个节点
        list.get(list.size() - k - 1).next = null;

        // 最后节点的下一个为头节点
        return list.get(list.size() - k);
    }


    public static void main(String[] args) {
        ListNode listNode = new RotateList().rotateRight(new ListNode(1).append(2).append(3).append(4).append(5), 2);
    }
}
