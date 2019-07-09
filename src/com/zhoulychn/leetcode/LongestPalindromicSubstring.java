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

    // 中心扩散法，从i 开始，以i为中心左右查找，如果i+1 =i，以这个对开始查找
    public String longestPalindrome(String s) {
        if (s.length() <= 1) return s;
        for (int i = 0; i < s.length() - 1; i++) {

            //单点为中心查找
            int x = i, y = i;
            while (isPalindrome(s, --x, ++y)) ;
            res = --y - ++x + 1 > res.length() ? s.substring(x, y + 1) : res;

            //成对查找
            if (s.charAt(i) == s.charAt(i + 1)) {
                x = i;
                y = i + 1;
                while (isPalindrome(s, --x, ++y)) ;
                res = --y - ++x + 1 > res.length() ? s.substring(x, y + 1) : res;
            }
        }
        return res;
    }

    //判断回文串方法
    public boolean isPalindrome(String s, int i, int j) {
        if (i == j) return true;
        if (i < 0 || j >= s.length()) return false;
        return s.charAt(i) == s.charAt(j);
    }

    //动态规划
    public String dp(String s) {
        if (s.length() <= 1) return s;

        String result = s.substring(0, 1);

        boolean[][] dp = new boolean[s.length()][s.length()];


        //区间慢慢扩大的遍历，防止需要dp[l + 1][r - 1]做判断时，这个数据并没有初始化
        for (int r = 1; r < s.length(); r++) {
            for (int l = 0; l < r; l++) {

                //r - l = 1或2时，中间只有一个元素或者无元素就不用判断了，左右相等就是回文串
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    result = r - l + 1 > result.length() ? s.substring(l, r + 1) : result;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().dp("aaabaaaa"));
    }
}
