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

public class DecodeWays {
    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        if (chars[0] == '0') return 0;

        //dp[-1] = dp[0] = 1
        int v1 = 1, v2 = 1;


        for (int i = 1; i < chars.length; i++) {
            int tmp = v2;
            if (chars[i] == '0')
                if (chars[i - 1] == '1' || chars[i - 1] == '2') v2 = v1;
                else return 0;
            else if (chars[i - 1] == '1' || (chars[i - 1] == '2' && chars[i] >= '1' && chars[i] <= '6')) v2 = v2 + v1;
            v1 = tmp;
        }
        return v2;
    }

    public static void main(String[] args) {
        System.out.println('7' - '0');
        new DecodeWays().numDecodings("12");
    }
}
