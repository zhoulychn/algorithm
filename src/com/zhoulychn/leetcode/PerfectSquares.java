package com.zhoulychn.leetcode;

/*

给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

示例 1:

输入: n = 12
输出: 3
解释: 12 = 4 + 4 + 4.
示例 2:

输入: n = 13
输出: 2
解释: 13 = 4 + 9.

 */

public class PerfectSquares {
    public int numSquares(int n) {

        // 默认初始化值都为0
        int[] ops = new int[n + 1];
        for (int i = 1; i <= n; i++) {

            // 最坏的情况就是每次+1
            ops[i] = i;

            // ops[i - j * j] + 1判断这个选择是否更好，只要i-j*j大于0就行了
            for (int j = 1; i - j * j >= 0; j++) {
                ops[i] = Math.min(ops[i], ops[i - j * j] + 1);
            }
        }
        return ops[n];
    }
}
