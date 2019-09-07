package com.zhoulychn.leetcode;

public class 最长公共子串 {

    public static int lcs(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] ops = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 || j == 0) {
                    ops[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    ops[i][j] = ops[i - 1][j - 1] + 1;
                } else {
                    ops[i][j] = Math.max(ops[i - 1][j], ops[i][j - 1]);
                }
            }
        }
        return ops[len1][len2];
    }
}
