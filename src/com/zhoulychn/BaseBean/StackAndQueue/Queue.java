package com.zhoulychn.BaseBean.StackAndQueue;

import java.util.Deque;

public class Queue {

    private int[] data;

    private int front;

    private int rear;

    private final int capacity;

    public Queue(int capacity) {
        this.capacity = capacity;
        data = new int[capacity];
        front = 0;
        rear = 0;

    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public int getFront() {
        return front;
    }

    public void setFront(int front) {
        this.front = front;
    }

    public int getRear() {
        return rear;
    }

    public void setRear(int rear) {
        this.rear = rear;
    }

    public int getCapacity() {
        return capacity;
    }
}
