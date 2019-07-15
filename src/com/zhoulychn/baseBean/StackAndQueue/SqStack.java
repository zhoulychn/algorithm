package com.zhoulychn.baseBean.StackAndQueue;

@SuppressWarnings("unchecked")
public class SqStack<E> {

    private Object[] data;

    private int top;

    public SqStack() {
        this(16);
    }

    public SqStack(int capacity) {
        data = new Object[capacity];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isNotEmpty() {
        return top == 1;
    }

    public boolean push(E e) {
        if (top == data.length - 1) {
            return false;
        }
        data[++top] = e;
        return true;
    }


    public E pop() {
        return (E) data[top--];
    }

    public E getTop() {
        return (E) data[top];
    }
}
