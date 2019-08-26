package com.zhoulychn.exam;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class 游戏 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] data = new int[4][4];
        for (int i = 0; i < 4; i++) {
            String[] s = sc.nextLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                data[i][j] = Integer.parseInt(s[j]);
            }
        }
        calc(n, data);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void calc(int n, int[][] data) {
        if (n == 1) {
            for (int i = 0; i < 4; i++) {
                List<Integer> list = new ArrayList<>();
                for (int j = 0; j < 4; j++) {
                    if (data[j][i] != 0) list.add(data[j][i]);
                }
                if (list.size() == 0) {
                    continue;
                }
                int j = 0;
                while (list.size() > 0) {
                    if (list.size() > 1 && list.get(0).equals(list.get(1))) {
                        data[j++][i] = list.get(j) * 2;
                        list.remove(0);
                        list.remove(0);
                    } else {
                        data[j++][i] = list.get(0);
                        list.remove(0);
                    }
                }
                while (j <= 3) {
                    data[j++][i] = 0;
                }
            }
        }
    }
}
