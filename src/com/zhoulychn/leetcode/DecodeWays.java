package com.zhoulychn.leetcode;

/*

一条包含字母 A-Z 的消息通过以下方式进行了编码：

'A' -> 1
'B' -> 2
...
'Z' -> 26
给定一个只包含数字的非空字符串，请计算解码方法的总数。

示例 1:

输入: "12"
输出: 2
解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
示例 2:

输入: "226"
输出: 3
解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。

 */

// TODO: 2019/07/29 未完成
public class DecodeWays {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        int count = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0' && (s.charAt(i - 1) == '0' || s.charAt(i - 1) - '0' > 2)) return 0;
            if (s.charAt(i - 1) != '0' && s.charAt(i) != '0' && s.charAt(i) - '0' <= 6) count++;

        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println('7' - '0');
        new DecodeWays().numDecodings("12");
    }
}
