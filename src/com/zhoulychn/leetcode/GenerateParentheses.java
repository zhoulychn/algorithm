package com.zhoulychn.leetcode;

/*

给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

例如，给出 n = 3，生成结果为：

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

 */

import java.util.*;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        HashMap<String, Integer> num = new HashMap<>();
        HashMap<String, Integer> surplus = new HashMap<>();
        res.add("(");
        num.put("(", 1);
        surplus.put("(", 1);
        for (int i = 1; i < 2 * n; i++) {
            List<String> temp = new ArrayList<>();
            for (String str : res) {

                // 如果左括号的数量小于n，可以再加左括号
                if (num.get(str) < n) {
                    temp.add(str + "(");
                    num.put(str + "(", num.get(str) + 1);
                    surplus.put(str + "(", surplus.get(str) + 1);
                }

                // 如果抵消后的括号大于0，可以加右括号
                if (surplus.get(str) > 0) {
                    temp.add(str + ")");
                    num.put(str + ")", num.get(str));
                    surplus.put(str + ")", surplus.get(str) - 1);
                }
            }
            res = temp;
        }
        return res;
    }

    public static void main(String[] args) {
        new GenerateParentheses().generateParenthesis(3);
    }
}
