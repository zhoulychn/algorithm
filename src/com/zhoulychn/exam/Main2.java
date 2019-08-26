package com.zhoulychn.exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {

    public static Map<Integer, Integer> temp = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        for (int i = 0; i < sum; i++) {
            int n = sc.nextInt();
            System.out.println(calc(n));
        }
    }

    public static boolean calc(int n) {
        if (n <= 0) return false;
        if (n == 1) return true;
        int k = 1;
        int count = 0;
        for (int i = 0; i < (n + "").length(); i++) {
            count += Math.pow((n + "").charAt(i) - '0', 2);
        }
        if (count == 1) return true;
        if (temp.containsKey(count)) {
            return false;
        } else {
            temp.put(count, k++);
        }
        return calc(n);
    }

}
