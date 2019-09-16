package com.zhoulychn.剑指Offer;

public class 左旋字符串 {

    public String LeftRotateString(String str, int n) {
        if (str.length() == 0 || n == 0 || n % str.length() == 0) return str;
        char[] chars = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            chars[(i + str.length() - n) % str.length()] = str.charAt(i);
        }
        return new String(chars);
    }
}
