package com.zhoulychn.剑指Offer;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 */
public class 等差数列 {

    public int Sum_Solution(int n) {
        if (n == 0) return 0;
        return n + Sum_Solution(n - 1);
    }

    public int Sum_Solution1(int n) {
        return (int) (n + Math.pow(n, 2)) >> 1;
    }
}
