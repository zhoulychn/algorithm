package com.zhoulychn.剑指Offer;

import java.util.Stack;

/*

输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列
但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）

 */
public class 栈的压入弹出序列 {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> st = new Stack<>();

        // 出栈索引
        int j = 0;
        if (pushA.length == 0 || popA.length == 0)
            return false;
        for (int i = 0; i < pushA.length; i++) {
            st.push(pushA[i]);

            // 如果辅助栈顶元素等于 出栈元素，则弹出
            while (!st.empty() && st.peek() == popA[j]) {
                st.pop();
                j++;
            }
        }
        return st.empty();
    }

    public static void main(String[] args) {
        boolean b = new 栈的压入弹出序列().IsPopOrder(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2});
    }
}
