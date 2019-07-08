package com.zhoulychn.leetcode;


/*
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"

 */

@SuppressWarnings("all")
public class LongestPalindromicSubstring {

    public String res = "";

    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        for (int i = 0; i < s.length() - 1; i++) {
            int x = i, y = i;
            while (isPalindrome(s, --x, ++y)) ;
            res = --y - ++x + 1 > res.length() ? s.substring(x, y + 1) : res;
            if (s.charAt(i) == s.charAt(i + 1)) {
                x = i;
                y = i + 1;
                while (isPalindrome(s, --x, ++y)) ;
                res = --y - ++x + 1 > res.length() ? s.substring(x, y + 1) : res;
            }
        }
        return res;
    }

    public boolean isPalindrome(String s, int i, int j) {
        if (i == j) return true;
        if (i < 0 || j >= s.length()) return false;
        return s.charAt(i) == s.charAt(j);
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("aaabaaaa"));
    }
}
