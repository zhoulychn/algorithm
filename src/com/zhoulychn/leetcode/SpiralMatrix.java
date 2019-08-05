package com.zhoulychn.leetcode;

import java.util.ArrayList;
import java.util.List;

/*

给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

示例 1:

输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
输出: [1,2,3,6,9,8,7,4,5]
示例 2:

输入:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
输出: [1,2,3,4,8,12,11,10,9,5,6,7]

 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new ArrayList<>();
        int c1 = 0, c2 = matrix[0].length - 1, r1 = 0, r2 = matrix.length - 1;
        List<Integer> res = new ArrayList<>(c2 * r2);
        while (c1 < c2 && r1 < r2) {
            for (int i = c1; i <= c2; i++) {
                res.add(matrix[r1][i]);
            }
            r1++;
            for (int i = r1; i <= r2; i++) {
                res.add(matrix[i][c2]);
            }
            c2--;
            for (int i = c2; i >= c1; i--) {
                res.add(matrix[r2][i]);
            }
            r2--;
            for (int i = r2; i >= r1; i--) {
                res.add(matrix[i][c1]);
            }
            c1++;
        }
        if (r1 == r2 && c1 == c2) {
            res.add(matrix[r1][c1]);
        }
        if (c1 == c2 && r1 < r2) {
            for (int i = r1; i <= r2; i++) {
                res.add(matrix[i][c1]);
            }
        }
        if (r1 == r2 && c1 < c2) {
            for (int i = c1; i <= c2; i++) {
                res.add(matrix[r1][i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        final List<Integer> list = new SpiralMatrix().spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}});
    }
}
