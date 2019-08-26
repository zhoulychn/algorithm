package com.zhoulychn.exam;

import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] data = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split(" ");
            for (int j = 0; j < s.length; j++) {
                data[i][j] = Integer.parseInt(s[j]);
            }
        }
        System.out.println(run(n, data));
    }

    public static int run(int n, int[][] data) {
        if (n == 0 || n == 1) return n;
        boolean[] ref = new boolean[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (dfs(data, i, ref) > 0) sum++;
        }
        return sum;
    }

    public static int dfs(int[][] data, int i, boolean[] ref) {
        if (ref[i]) return 0;
        ref[i] = true;
        int count = 1;
        for (int j = 0; j < ref.length; j++) {
            if (i != j && data[i][j] >= 3)
                count += dfs(data, j, ref);
        }
        return count;
    }
}
