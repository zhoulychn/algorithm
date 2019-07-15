package com.zhoulychn.lintCode;

//设计一个算法，计算出n阶乘中尾部零的个数。

public class Num_2 {

    public long trailingZeros(long n) {
        int sum = 1;
        while (n > 1) {
            sum *= n--;
        }
        return 0;
    }
}
