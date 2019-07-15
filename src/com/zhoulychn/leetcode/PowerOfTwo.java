package com.zhoulychn.leetcode;

/*
给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 */
public class PowerOfTwo {

    //一个数如果是2的次方，那么此数减1的二进制为全1.
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        String s = Integer.toBinaryString(n - 1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '1') return false;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean powerOfTwo = new PowerOfTwo().isPowerOfTwo(3);
    }
}
