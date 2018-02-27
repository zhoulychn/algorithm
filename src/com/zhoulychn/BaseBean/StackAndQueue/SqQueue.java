package com.zhoulychn.BaseBean.StackAndQueue;

@SuppressWarnings("unchecked")
public class SqQueue<E> {

    private Object[] data;

    private int front;

    private int rear;

    private int capacity;

    public SqQueue() {
        this(16);
    }

    public SqQueue(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity];
        front = 0;
        rear = 0;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isNotEmpty() {
        return front != rear;
    }

    public boolean enQueue(E e) {
        if ((rear + 1) % capacity == front) return false;
        data[rear] = e;
        rear = (rear + 1) % capacity;
        return true;
    }

    public E deQueue() {
        E result = (E) data[front];
        front = (front + 1) % capacity;
        return result;
    }

    public E getLast() {
        return (E) data[front];
    }

    public int size() {
        return (rear - front + capacity) % capacity;
    }
}
