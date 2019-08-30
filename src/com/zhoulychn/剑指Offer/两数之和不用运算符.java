package com.zhoulychn.剑指Offer;

import java.math.BigDecimal;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class 两数之和不用运算符 {

    public int Add(int num1, int num2) {
        BigDecimal i = new BigDecimal(num1);
        BigDecimal j = new BigDecimal(num2);
        return i.add(j).intValue();
    }
}
