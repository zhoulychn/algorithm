package com.zhoulychn.剑指Offer;

public class 整数中1出现的次数 {
    public int NumberOf1Between1AndN_Solution(int n) {
        long count = 0;
        long i = 1;
        for (i = 1; i <= n; i *= 10) {
            //i表示当前分析的是哪一个数位
            long a = n / i, b = n % i;
            count = count + (a + 8) / 10 * i + ((a % 10 == 1) ? (b + 1) : 0);
        }
        return (int) count;
    }


}
