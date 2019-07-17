package com.zhoulychn.common.list;

public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode append(int x) {
        ListNode temp = this;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new ListNode(x);
        return this;
    }

    @Override
    public String toString() {
        return val + "," + (next == null ? "null" : next);
    }
}
