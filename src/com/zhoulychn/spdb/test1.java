package com.zhoulychn.spdb;

import com.sun.xml.internal.ws.spi.db.DatabindingException;

import java.math.BigDecimal;
import java.security.PublicKey;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;

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

    public static void method5() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date date = new Date();
        String format1 = format.format(date);
        System.out.println(format1);

        Date parse = format.parse("2020-1-21 16:23:23.432");
        System.out.println(format.format(parse));
        long l = System.nanoTime();
    }

    static class MyException extends Exception {

        public MyException(String message) {
            super(message);
        }

        public MyException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static void main(String[] args) throws ParseException {
//        method1(new int[]{1, 2, 3, 4, 5, 2, 3, 4, 6});
//        method2("asdfaAASDFAS1123");
//        method4();
        List<String> list = new ArrayList<String>() {{
            add("1");
            add("2");
            add("3");
        }};

        System.out.println(list.getClass());

        Thread thread = new Thread(()->{
            System.out.println(1);
        });

        Map<String, String> map = new HashMap<String, String>() {{
            put("a", "b");
        }};

        Integer.parseInt("1");
        Integer.valueOf("1").intValue();
        System.out.println(list);
        System.out.println(map);
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            entry.getKey();
        }
        BigDecimal a = new BigDecimal("6.1");
        BigDecimal b = new BigDecimal("5.63");
        System.out.println(a.add(b));
        System.out.println(a.subtract(b));
        System.out.println(a.multiply(b));
        System.out.println(a.divide(b, 2, BigDecimal.ROUND_HALF_UP));
    }
}