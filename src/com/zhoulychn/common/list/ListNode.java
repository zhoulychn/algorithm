package com.zhoulychn.common.list;

public class ListNode {

    public int val;

    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int... arr) {
        val = arr[0];
        if (arr.length > 1) next = new ListNode(arr[1]);
        for (int i = 2; i < arr.length; i++) {
            this.append(arr[i]);
        }
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
