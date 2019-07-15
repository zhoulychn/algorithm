package com.zhoulychn.lintCode;

import org.junit.Test;

/**
 * Created by Lewis on 2018/3/8
 */
public class Num_28 {

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length == 0 || target < matrix[0][0]) {
            return false;
        }

        int row = matrix.length, column = matrix[0].length;

        if ((row == column) && (target > matrix[row - 1][row - 1]))
            return false;
        int k = 0;
        for (int i = 0; (i < row) && (i < column); i++) {
            k = matrix[i][i];

            if (target < k) {
                for (int j = i - 1; j >= 0; j--) {
                    int val = matrix[i][j];
                    if (target == val)
                        return true;
                    if (target > val)
                        return false;
                }
                for (int j = column - 1; j >= i; j--) {
                    int val = matrix[i - 1][j];
                    if (target == val)
                        return true;
                    if (target > val)
                        return false;
                }
            }
            if (target == k)
                return true;
        }
        if (target > k) {
            if (column > row) {
                for (int j = row; j < column; j++) {
                    int val = matrix[row - 1][j];
                    if (target == val)
                        return true;
                    if (target < val)
                        return false;
                }
                return false;
            } else {
                for (int j = 0; j < column; j++) {
                    int val = matrix[column - 1][j];
                    if (target == val)
                        return true;
                    if (target < val)
                        return false;
                }
                return false;
            }
        }
        return false;
    }

    @Test
    public void run() {
        System.out.println(searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}}, 50));
    }
}
