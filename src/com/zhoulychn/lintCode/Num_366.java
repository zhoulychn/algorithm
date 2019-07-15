package com.zhoulychn.lintCode;

import org.junit.Test;

public class Num_366 {

    /**
     * @param n: an integer
     * @return: an ineger f(n)
     */
    public int fibonacci(int n) {
        if (n <= 1)
            return 0;

        if (n == 2)
            return 1;

        int first = 0;
        int second = 1;

        //把上两次求和值为second，上一次值为first，依次循环
        for (int i = 2; i < n; i++) {
            int temp = first + second;
            first = second;
            second = temp;
        }

        return second;
    }

    @Test
    public void run() {
        System.out.println(fibonacci(20));
    }
}
