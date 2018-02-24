package com.zhoulychn.BaseBean.StackAndQueue;

public class SqStack {

    private int[] data;

    private int top;

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public SqStack(int capacity) {
        data = new int[capacity];
        top = -1;
    }
}
