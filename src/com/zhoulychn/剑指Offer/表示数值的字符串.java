package com.zhoulychn.剑指Offer;

public class 表示数值的字符串 {

    public boolean isNumeric(char[] str) {
        try {
            Double.parseDouble(new String(str));
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
