package com.zhoulychn;

import java.util.Scanner;

public class Main1 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int v1 = 0;
        int v2 = 0;
        int x1 = 0;
        int x2 = 0;


        String[] arr1 = scanner.nextLine().split(" ");

        for (String str : arr1) {
            if (Integer.parseInt(str) % 2 == 0) v2++;
            else v1++;
        }
        String[] arr2 = scanner.nextLine().split(" ");
        for (String str : arr2) {
            if (Integer.parseInt(str) % 2 == 0) x2++;
            else x1++;
        }

        System.out.println(Math.min(v1, x2) + Math.min(v2, x1));

    }

}
