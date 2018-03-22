package com.zhoulychn.LintCode;

import java.util.HashSet;

/**
 * Created by Lewis on 2018/3/19
 */

public class Num_125 {

    public static int backPackII(int m, int[] A, int[] V) {
        int s = A.length;
        int wt[][] = new int[s + 1][m + 1];
        for (int i = 1; i <= s; i++) {
            int weight = A[i - 1], value = V[i - 1];
            for (int j = 1; j <= m; j++) {
                if (j >= weight)
                    wt[i][j] = Math.max(wt[i - 1][j], wt[i - 1][j - weight] + value);
                else
                    wt[i][j] = wt[i - 1][j];
            }
        }
        return wt[s][m];
    }

    public static void main(String[] args) {
        System.out.println(backPackII(100, new int[]{77, 22, 29, 50, 99}, new int[]{92, 22, 87, 46, 90}));
    }
}
