package com.zhoulychn.Utils;

import com.zhoulychn.BaseBean.StackAndQueue.SqStack;

public class StackUtils {

    public static boolean isEmpty(SqStack stack) {
        return stack.getTop() == -1;
    }

    public static boolean push(SqStack stack, int value) {

        int[] data = stack.getData();
        int top = stack.getTop();

        if (top == data.length - 1) {
            return false;
        }
        data[++top] = value;
        stack.setTop(top);
        return true;
    }

    public static int pop(SqStack stack) {
        int top = stack.getTop();
        int value = stack.getData()[top--];
        stack.setTop(top);
        return value;
    }

    public static int getTop(SqStack stack) {
        int[] data = stack.getData();
        int top = stack.getTop();
        return data[top];
    }

}
