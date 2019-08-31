package com.zhoulychn.leetcode;

/*

实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

示例 1:

输入: haystack = "hello", needle = "ll"
输出: 2
示例 2:

输入: haystack = "aaaaa", needle = "bba"
输出: -1
说明:

当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。

 */
public class ImplementStrstr {

    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) return 0;
        if (haystack.length() < needle.length()) return -1;
        if (haystack.length() == needle.length()) return haystack.equals(needle) ? 0 : -1;

        int[] next = getNext(needle);

        int i = 0, j = 0;
        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) Math.max(++i, ++j);

            // 不相等且next数组为-1，则下一个支付重新匹配
            else if (next[j] == -1) i++;

            // next数组有值，j跳到下一个比对位置
            else j = next[j];
        }
        return j == needle.length() ? i - j : -1;
    }

    private int[] getNext(String str) {
        int[] next = new int[str.length()];
        next[0] = -1;
        for (int i = 2, cn = 0; i < next.length; ) {

            // cn和末尾对比，相等的情况下，cn代表之前匹配过的长度，这时候next就是0-cn的长度。xxx cn=xxx [i-1]
            if (str.charAt(cn) == str.charAt(i - 1)) next[i++] = ++cn;

            // 继续向前
            else if (cn > 0) cn = next[cn];

            // 没有匹配的
            else next[i++] = 0;

        }
        return next;
    }

    public static void main(String[] args) {
        int[] ababas = new ImplementStrstr().getNext("ababad");
    }
}
