package com.zhoulychn.leetcode;

/*

给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。

具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。

示例 1:

输入: "abc"
输出: 3
解释: 三个回文子串: "a", "b", "c".
示例 2:

输入: "aaa"
输出: 6
说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
注意:

输入的字符串长度不会超过1000。

 */
public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        if (s.length() <= 1) return s.length();

        int count = 0;

        // i->j 是否为回文串，如果i和j之间的数小于2，只用判断是否i和j的字符是否相同，否则判断dp[i-1][j+1]是否构成回文串
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {

                if (s.charAt(i) == s.charAt(j)) {
                    if (i - j < 2) dp[i][j] = true;
                    else if (dp[i - 1][j + 1]) dp[i][j] = true;
                }

                if (dp[i][j]) count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int aaa = new PalindromicSubstrings().countSubstrings("aaa");
    }
}
