package com.zhoulychn.leetcode;


import java.util.ArrayList;
import java.util.List;

/*

判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

示例 1:

输入: 121
输出: true
示例 2:

输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
示例 3:

输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。
进阶:

你能不将整数转为字符串来解决这个问题吗？

 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        if (x < 10) return true;

        List<Integer> list = new ArrayList<>();

        while (x % 10 != x) {
            list.add(x % 10);
            x /= 10;
        }
        list.add(x);

        for (int i = 0, j = list.size() - 1; i < j; i++, j--) {
            if (!list.get(i).equals(list.get(j))) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new PalindromeNumber().isPalindrome(121);
    }
}
