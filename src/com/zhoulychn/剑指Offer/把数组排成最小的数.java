package com.zhoulychn.剑指Offer;

import java.util.LinkedList;
/*

输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。

 */
public class 把数组排成最小的数 {
    public String PrintMinNumber(int[] numbers) {
        if (numbers.length == 1) return String.valueOf(numbers[0]);
        LinkedList<String> list = new LinkedList<>();
        for (int number : numbers) {
            list.add(String.valueOf(number));
        }
        list.sort((v1, v2) -> Integer.compare(Integer.parseInt(v1 + v2), Integer.parseInt(v2 + v1)));
        StringBuilder result = new StringBuilder("");
        for (String s : list) {
            result.append(s);
        }
        return result.toString();
    }
}
