package com.zhoulychn.exam.huawei;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(calc(n));
    }

    private static int calc(int n) {
        int i = 0;
        while (n > 0) {
            if (n % 9 == 0) {
                return i + n / 9;
            } else {
                n -= 4;
                i++;
            }
        }
        return -1;
    }
}