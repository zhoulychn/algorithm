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

public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int max = 0;

        // 某个位置构成面积的边长
        int[][] ops = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                // 如果当前元素为0，则这个位置不可能构成正方形
                if (matrix[i][j] == '0') {
                    ops[i][j] = 0;
                    continue;
                }

                // 如果当前元素为1，面积最少是1
                ops[i][j] = 1;

                // 左上角的边长>0，并且不是边界
                if (i - 1 >= 0 && j - 1 >= 0 && ops[i - 1][j - 1] > 0) {


                    // 左上角的边长
                    for (int k = 1; k <= ops[i - 1][j - 1]; k++) {

                        // 上一步和左一部为1，边长+1
                        if (matrix[i - k][j] == '1' && matrix[i][j - k] == '1') ops[i][j] += 1;

                        // 如果不是1，提前退出
                        else break;
                    }
                }
                max = Math.max(max, ops[i][j]);
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        int i = new MaximalSquare().maximalSquare(new char[][]{{'0', '0', '0', '1'}, {'1', '1', '0', '1'}, {'1', '1', '1', '1'}, {'0', '1', '1', '1'}, {'0', '1', '1', '1'}});
    }
}
