package com.zhoulychn.剑指Offer;

import java.util.ArrayList;

public class 顺时针矩阵打印 {

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        ArrayList<Integer> res = new ArrayList<>(bottom * right);
        while (top < bottom && left < right) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }
            right--;
            for (int i = right; i >= left; i--) {
                res.add(matrix[bottom][i]);
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
        }

        if (top == bottom && left == right) res.add(matrix[top][left]);
        if (top == bottom && left < right) {
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
        }
        if (left == right && top < bottom) {
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][left]);
            }
        }
        return res;
    }
}
