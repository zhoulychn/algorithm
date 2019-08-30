package com.zhoulychn.剑指Offer;

import com.zhoulychn.common.list.ListNode;

import java.util.ArrayList;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class 逆序打印链表 {

    private ArrayList<Integer> res = new ArrayList<>();

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        run(listNode);
        return res;
    }

    public void run(ListNode listNode) {
        if (listNode != null) {
            run(listNode.next);
            res.add(listNode.val);
        }
    }
}
