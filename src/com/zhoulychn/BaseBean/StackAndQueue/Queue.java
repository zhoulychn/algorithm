package com.zhoulychn.BaseBean.StackAndQueue;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

@SuppressWarnings("unchecked")
public class Queue<E> {

    private Object[] data;

    private int front;

    private int rear;

    private final int capacity;

    public Queue(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity];
        front = 0;
        rear = 0;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean enQueue( E e) {
        if ((rear + 1) % capacity == front) return false;
        data[rear++] = e;
        return true;
    }


    public E deQueue() {
        return (E) data[front++];
    }
}
