package com.zhoulychn.exam;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine().replace(" ","");
        String s2 = sc.nextLine().replace(" ","");
        int v1 = 0;
        int v2 = 0;
        while (v1 < s1.length() || v2 < s2.length()) {
            for (int i = 0; i < 4; i++) {
                if (v1 >= s1.length()) break;
                System.out.print(s1.charAt(v1++)+" ");
            }
            if (v2 < s2.length()) System.out.print(s2.charAt(v2++)+" ");
        }
    }
}
