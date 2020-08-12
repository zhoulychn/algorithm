package com.zhoulychn.spdb;

import java.math.BigDecimal;
import java.util.*;

public class test1 {

    public static Integer[] method1(int[] arr) {
        Map<Integer, Object> map = new HashMap<>();
        for (int i : arr) {
            if (map.containsKey(i)) continue;
            map.put(i, null);
        }
        Set<Integer> set = map.keySet();
        ArrayList<Integer> integers = new ArrayList<>(set);
        Integer[] res = new Integer[integers.size()];
        integers.toArray(res);
        return res;
    }

    public static void method2(String str) {
        char[] chars = str.toCharArray();

        int charactor = 0, number = 0;

        for (char item : chars) {
            if (item >= 'A' && item <= 'Z') charactor++;
            if (item >= 'a' && item <= 'z') charactor++;
            if (item >= '0' && item <= '9') number++;
        }

        System.out.println(charactor);
        System.out.println(number);
    }

    public static void method3() throws MyException {
        throw new MyException("error,lewis");
    }

    public static void method4() {
        try {
            method3();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    static class MyException extends Exception {

        public MyException(String message) {
            super(message);
        }

        public MyException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static void main(String[] args) {
//        method1(new int[]{1, 2, 3, 4, 5, 2, 3, 4, 6});
//        method2("asdfaAASDFAS1123");
        method4();
    }

}