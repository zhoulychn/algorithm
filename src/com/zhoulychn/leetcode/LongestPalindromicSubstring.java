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
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        int x = 0, y = 0;
        for (int k = 0; k < s.length(); k++) {
            int i = k, j = k;
            while (isPalindrome(s, i, j)) {
                i--;
                j++;
            }
            i++;
            j--;
            if (j - i >= y - x) {
                y = j;
                x = i;
            }
            if (k + 1 < s.length() && s.charAt(k) == s.charAt(k + 1)) {
                i = k;
                j = k + 1;
                while (isPalindrome(s, i, j)) {
                    i--;
                    j++;
                }
                i++;
                j--;
                if (j - i >= y - x) {
                    y = j;
                    x = i;
                }
            }
        }
        return s.substring(x, y);
    }

    public boolean isPalindrome(String s, int i, int j) {
        if (i == j) return true;
        if (i < 0 || j >= s.length()) return false;
        return s.charAt(i) == s.charAt(j);
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("babad"));
    }
}
