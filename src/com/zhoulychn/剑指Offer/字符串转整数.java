package com.zhoulychn.剑指Offer;

public class 字符串转整数 {

    public int StrToInt(String str) {
        if (str.length() == 0) return 0;
        int value = 0;
        int temp = 1;
        for (int i = str.length() - 1; i >= 0; i--) {
            char c = str.charAt(i);
            if (c == '+' || c == '-') {

                // 判断+-号前面的字符，必须为空格
                for (int j = i - 1; j >= 0; j--) {
                    if (str.charAt(j) != ' ') return 0;
                }

                // 判断完成功后返回
                return c == '-' ? -value : value;
            }

            // 判断数字，然后加上
            int v = str.charAt(i) - '0';
            if (v < 0 || v > 9) return 0;
            value += v * temp;
            temp *= 10;
        }
        return value;
    }
}
