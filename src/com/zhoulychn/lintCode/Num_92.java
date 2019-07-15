package com.zhoulychn.lintCode;

/**
 * Created by Lewis on 2018/3/19
 */

public class Num_92 {

    public static int backPack(int m, int[] A) {
        int f[] = new int[m + 1];

        for (int i : A) {

            for (int j = m; j >= i; j--) {
                f[j] = Math.max(f[j], f[j - i] + i);
            }

        }
        return f[m];
    }

    public static void main(String[] args) {
        System.out.println(backPack(11, new int[]{2, 3, 5, 7}));
    }
}
