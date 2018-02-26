package com.zhoulychn.BaseBean.List;

public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode append(int x) {
        ListNode temp = next;
        while (temp != null) {
            temp = temp.next;
        }
        temp = new ListNode(x);
        return this;
    }
}
