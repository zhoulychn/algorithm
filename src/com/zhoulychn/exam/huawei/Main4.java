package com.zhoulychn.exam.huawei;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main4 {

    public int run(int[] num) {
        int result = Integer.MAX_VALUE;
        for (int i = 1; i < num.length / 2; i++) {
            int sum = i;
            int n = 1;
            while (sum < num.length - 1) {
                sum += num[sum];
                n++;
            }
            if (sum == num.length - 1 && n < result) result = n;
        }
        return result != Integer.MAX_VALUE ? result : -1;
    }


    public static void main(String[] args) {
        int run = new Main4().run(new int[]{7, 2, 9, 4, 2, 6, 8, 3, 5, 4, 2, 9});
        System.out.println(run);
    }
}
