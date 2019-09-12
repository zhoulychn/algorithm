package com.zhoulychn.exam.bytedance;

import java.util.ArrayList;
import java.util.HashMap;

public class Main1 {

    public int watch(int[] arr) {
        if (arr.length < 2) return 0;
        int result = 0, height = arr[arr.length - 1];
        for (int i = arr.length - 1; i >= 0; i--) {
            int sum = 0, pre = 0;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] <= arr[i] && arr[j] > pre) {
                    sum++;
                    pre = arr[j];
                }
            }
            if (sum >= result) {
                height = arr[i];
                result = sum;
            }
        }

        return height;
    }

    public static void main(String[] args) {
        int watch = new Main1().watch(new int[]{3, 8, 3, 4, 6, 3, 4, 1, 3, 7, 3, 6, 5, 3, 4});
    }
}
