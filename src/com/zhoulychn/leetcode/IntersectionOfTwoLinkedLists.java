package com.zhoulychn.leetcode;

/*

编写一个程序，找到两个单链表相交的起始节点。

注意：

如果两个链表没有交点，返回 null.
在返回结果后，两个链表仍须保持原有的结构。
可假定整个链表结构中没有循环。
程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。

 */

import com.zhoulychn.common.list.ListNode;

import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoLinkedLists {

    // 遍历第一个链表，按照hashcode-node放入map，遍历下一个链表，第一个获取到的节点就是相遇的节点
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Map<Integer, ListNode> map = new HashMap<>(10000);
        while (headA != null) {
            map.put(headA.hashCode(), headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (map.get(headB.hashCode()) != null) return map.get(headB.hashCode());
            headB = headB.next;

        }
        return null;
    }

    //先找到链表长度，然后更长的先遍历过多的那部分长度，再一起遍历就能找到了
    public ListNode backup(ListNode headA, ListNode headB) {
        ListNode p = headA, q = headB;
        int lenA = 0, lenB = 0;
        while (p != null) {
            lenA++;
            p = p.next;
        }
        while (q != null) {
            lenB++;
            q = q.next;
        }

        p = headA;
        q = headB;
        while (lenA > lenB) {
            p = p.next;
            lenA--;
        }
        while (lenB > lenA) {
            q = q.next;
            lenB--;
        }

        for (int i = 0; i < lenA; i++) {
            if (p == q) return p;
            p = p.next;
            q = q.next;
        }
        return null;
    }
}
