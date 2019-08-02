package com.zhoulychn.leetcode;

/*

在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。

示例:

输入:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

输出: 4

 */

// TODO: 2019/07/30 未完成
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {

        int[] dp = new int[matrix[0].length];

        for (int i = 0; i < matrix[0].length; i++) {
            dp[i] = matrix[0][i];
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

            }
        }
        return 0;
    }
}
