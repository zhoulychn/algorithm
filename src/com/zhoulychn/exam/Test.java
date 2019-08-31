package com.zhoulychn.exam;

import java.util.Random;

public class Test {

    public static void main(String[] args) {

        int k = 0;
        for (int i = 0; i < 100000000; i++) {
            Random random = new Random();
            int v1 = random.nextInt(100);
            int v2 = random.nextInt(100);
            int v3 = random.nextInt(100);

            boolean b = v1 + v2 > v3 && v1 + v3 > v2 && v2 + v3 > v1;
            if (b) {
                k++;
            }
        }
        System.out.println(k / 100000000);

    }
}
