package com.zhoulychn.剑指Offer;

import java.util.Stack;

public class 最小值的栈 {

    private Stack<Integer> min = new Stack<>();
    private Stack<Integer> stack = new Stack<>();

    public void push(int node) {
        stack.push(node);
        if (min.isEmpty() || node <= min.peek()) min.push(node);
    }

    public void pop() {
        if (stack.isEmpty()) return;
        int v = stack.pop();
        if (!min.isEmpty() && min.peek().equals(v)) min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }
}
