package com.zhoulychn.exam;

import java.util.Scanner;

public class 花园 {

    public static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = -1;
        }
    }

    public static int calc(int n) {
        if (arr[n] < 0) return n;
        else return calc(arr[n]);
    }
}
