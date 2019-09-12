package com.zhoulychn.剑指Offer;

public class 斐波那契数列 {

    public int Fibonacci(int n) {
        if (n < 1) return 0;
        if (n < 3) return 1;
        int v1 = 1, v2 = 1;
        for (int i = 3; i <= n; i++) {
            int temp = v2;
            v2 = v1 + v2;
            v1 = temp;
        }
        return v2;
    }
}
