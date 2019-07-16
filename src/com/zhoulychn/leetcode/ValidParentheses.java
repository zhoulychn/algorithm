package com.zhoulychn.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/*

给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true

 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if (s.length() == 0) return true;

        if (s.length() % 2 != 0) return false;

        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {

            //如果和上一个匹配，则移除上一个
            if (deque.size() != 0 && isMatch(deque.getLast(), s.charAt(i))) deque.pollLast();

            //加入队列
            else deque.addLast(s.charAt(i));
        }
        while (deque.size() != 0) {
            if (!isMatch(deque.pollFirst(), deque.pollLast())) return false;
        }
        return true;
    }

    // 判断两个符号是否匹配
    public boolean isMatch(Character a, Character b) {
        if (a.equals('(')) return b.equals(')');
        if (a.equals('[')) return b.equals(']');
        if (a.equals('{')) return b.equals('}');
        return false;
    }

    public static void main(String[] args) {
        new ValidParentheses().isValid("()");
    }
}
