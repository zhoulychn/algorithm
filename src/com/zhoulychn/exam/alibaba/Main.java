package com.zhoulychn.exam.alibaba;

import java.util.Scanner;

public class Main {

    public static void main1(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        int n = Integer.parseInt(line);
        int[][] area = new int[n][n];

        for (int i = 0; i < n; i++) {
            line = scanner.nextLine();
            String[] split = line.split(",");
            if (split.length != n) {
                throw new IllegalArgumentException("错误输入");
            }
            int j = 0;
            for (String num : split) {
                area[i][j++] = Integer.parseInt(num);
            }
        }

        int minimumTimeCost = getMinimumTimeCost(n, area);
        System.out.println(minimumTimeCost);
    }

    /** 请完成下面这个函数，实现题目要求的功能 **/
    /**
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^
     **/
    private static int getMinimumTimeCost(int n, int[][] area) {
        int[][] ops = new int[n][n];
        ops[0][0] = Integer.MAX_VALUE;
        ops[0][1] = 0;
        ops[1][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                if (i == 0 && j == 1) continue;
                if (i == 1 && j == 0) continue;

                int v1 = (j - 2 < 0 || ops[i][j - 2] == Integer.MAX_VALUE) ? Integer.MAX_VALUE : ops[i][j - 2] + area[i][j - 1];

                int v2 = (i - 2 < 0 || ops[i - 2][j] == Integer.MAX_VALUE) ? Integer.MAX_VALUE : ops[i - 2][j] + area[i - 1][j];

                ops[i][j] = Math.min(v1, v2);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {

            int v2 = (n - 1 < 0 || ops[n - 1][j] == Integer.MAX_VALUE) ? Integer.MAX_VALUE : ops[n - 1][j] + area[n - 1][j];

            min = Math.min(min, v2);
        }
        return min;
    }

    public static void main(String[] args) {

        int[][] area = new int[][]{
                {35, 92, 98, 68, 35, 65, 26, 72},
                {29, 78, 83, 16, 5, 89, 92, 28},
                {48, 51, 37, 79, 65, 74, 50, 71},
                {98, 78, 99, 57, 1, 30, 22, 16},
                {72, 88, 55, 33, 56, 58, 28, 49},
                {4, 28, 29, 20, 18, 61, 11, 73},
                {61, 19, 47, 34, 85, 32, 77, 89},
                {29, 49, 10, 81, 52, 5, 63, 25}
        };

        int minimumTimeCost = Main.getMinimumTimeCost(8, area);
    }
}
