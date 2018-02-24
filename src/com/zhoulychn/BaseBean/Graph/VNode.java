package com.zhoulychn.BaseBean.Graph;

public class VNode {

    private int data;

    private Arc first;

    public VNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Arc getFirst() {
        return first;
    }

    public void setFirst(Arc first) {
        this.first = first;
    }
}
