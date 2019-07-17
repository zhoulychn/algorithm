package com.zhoulychn.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*

设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。

push(x) -- 将元素 x 推入栈中。
pop() -- 删除栈顶的元素。
top() -- 获取栈顶元素。
getMin() -- 检索栈中的最小元素。
示例:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.

 */
public class MinStack {


    // 辅助栈存放最小元素
    private Stack<Integer> stack = new Stack<>();

    private Stack<Integer> min = new Stack<>();

    public MinStack() {
    }

    public void push(int x) {
        stack.push(x);

        //如果比前面更小，则入栈，比前面大就不需要了，因为栈是先进后出，最小的最后出
        if (min.size() == 0 || min.peek() >= x) min.push(x);
    }

    public void pop() {
        Integer value = stack.pop();
        if (value.equals(min.peek())) min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
