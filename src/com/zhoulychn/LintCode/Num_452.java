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

        head = head.next;

        while (head != null) {
            if (head.val != val) {
                result.next = new ListNode(head.val);
                result = result.next;
            }
            head = head.next;
        }

        return result;
    }

    @Test
    public void run() {
        ListNode p = new ListNode(1);
        p.append(2).append(6).append(3).append(4).append(5).append(6);
        removeElements(p, 6);
    }
}
