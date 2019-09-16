package com.zhoulychn;

import java.util.Scanner;

public class 状态 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int[] state = new int[n];

        String[] arr = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            state[i] = Integer.parseInt(arr[i]);
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            int sum = state[i];
            boolean l = false;
            boolean r = false;
            for (int j = i - 1, k = i + 1; (!l || !r) && (j > -1 || k < n); ) {
                if (!l && j > -1 && state[j] > state[i]) sum += state[j--];
                else l = true;

                if (!r && k < n && state[k] > state[i]) sum += state[k++];
                else r = true;
            }
            if (sum == state[i]) continue;
            max = Math.max(sum * state[i], max);
        }

        System.out.println(max);
    }
}
