package com.zhoulychn.exam;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        for (int i = 0; i < sum; i++) {
            String s1 = trs(sc.next());
            String s2 = trs(sc.next());

            for (int j = 0; j < 7; j++) {
                boolean x = s1.charAt(j) < s2.charAt(j);
                if (j == 6) System.out.println(x);
                if (s1.charAt(j) != s2.charAt(j)) {
                    System.out.print(x);
                    break;
                }
            }
        }
    }

    private static String trs(String str) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 0; i < (7 - str.length()) / 2; i++) {
            sb.append(".0");
        }
        return sb.toString();
    }
}
