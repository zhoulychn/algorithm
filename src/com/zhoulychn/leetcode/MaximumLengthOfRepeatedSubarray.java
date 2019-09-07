package com.zhoulychn.leetcode;

import java.util.TreeMap;

public class MaximumLengthOfRepeatedSubarray {

    public int findLength(int[] A, int[] B) {

        int[][] ops = new int[A.length + 1][B.length + 1];
        for (int i = 0; i <= A.length; i++) {
            for (int j = 0; j <= B.length; j++) {
                if (i == 0 || j == 0) ops[i][j] = 0;
                else if (A[i - 1] == B[j - 1]) ops[i][j] = ops[i - 1][j - 1] + 1;
                else ops[i][j] = Math.max(ops[i - 1][j], ops[i][j - 1]);
            }
        }


        return ops[A.length][B.length];


    }

    public static void main(String[] args) {
        int b = "ab".compareTo("b");
        System.out.println(b);
    }
}
