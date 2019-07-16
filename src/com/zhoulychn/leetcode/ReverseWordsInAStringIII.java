package com.zhoulychn.leetcode;

/*
给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

示例 1:

输入: "Let's take LeetCode contest"
输出: "s'teL ekat edoCteeL tsetnoc" 
注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。
 */
public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");

        if (arr.length == 0) return new StringBuilder(s).reverse().toString();
        StringBuilder sb = new StringBuilder();

        for (String item : arr) {
            sb.append(new StringBuilder(item).reverse()).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
