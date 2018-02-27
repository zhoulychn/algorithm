package com.zhoulychn.LintCode;

import com.zhoulychn.BaseBean.List.ListNode;
import org.junit.Test;

public class Num_452 {

    /*
     * @param head: a ListNode
     * @param val: An integer
     * @return: a ListNode
     */
    public ListNode removeElements(ListNode head, int val) {
        // write your code here

        while (head != null && head.val == val)
            head = head.next;

        if (head == null) return null;

        ListNode result = new ListNode(head.val);

        ListNode p = result;

        head = head.next;

        while (head != null) {
            if (head.val != val) {
                p.next = new ListNode(head.val);
                p = p.next;
            }
            head = head.next;
        }

        return result;
    }

    @Test
    public void run() {
        ListNode head = new ListNode(1);
        ListNode p = head;
        p.next = new ListNode(2);
        p = p.next;
        p.next = new ListNode(6);
        p = p.next;
        p.next = new ListNode(3);
        p = p.next;
        p.next = new ListNode(4);
        p = p.next;
        p.next = new ListNode(5);
        p = p.next;
        p = new ListNode(6);
        removeElements(head, 6);
    }
}
