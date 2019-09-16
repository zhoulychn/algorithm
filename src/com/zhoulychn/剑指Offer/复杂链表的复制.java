package com.zhoulychn.剑指Offer;

import com.zhoulychn.common.list.RandomListNode;

/*

输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
返回结果为复制后复杂链表的head。
（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）

 */
public class 复杂链表的复制 {

    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;

        RandomListNode p = pHead;

        while (p != null) {
            RandomListNode next = p.next;
            RandomListNode post = new RandomListNode(p.label);
            p.next = post;
            post.next = next;
            p = next;
        }

        p = pHead;
        while (p != null) {
            p.next.random = p.random == null ? null : p.random.next;
            p = p.next.next;
        }
        p = pHead;
        RandomListNode next = pHead.next;
        while (p != null) {
            RandomListNode copy = p.next;
            p.next = copy.next;
            copy.next = p.next == null ? null : p.next.next;
            p = p.next;
        }
        return next;
    }
}
