package com.zhoulychn.LintCode;

/**
 * Created by Lewis on 2018/3/7
 */
public class Num_12 {

    private int[] data = new int[64];

    private int[] minList = new int[64];

    private int top = -1;

    private int minTop = -1;

    public void push(int number) {
        data[++top] = number;
        if (minTop == -1 || number < data[minList[minTop]]) {
            minList[++minTop] = top;
        }
    }


    public int pop() {
        if (top == minList[minTop]) {
            minTop--;
        }
        return data[top--];
    }


    public int min() {
        return data[minList[minTop]];
    }
}
