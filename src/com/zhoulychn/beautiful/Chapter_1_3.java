package com.zhoulychn.beautiful;

import java.util.*;

/**
 * Created by Lewis on 2018/3/21
 */
public class Chapter_1_3 {

    public static int[] sort(int[] arr) {
        int len = arr.length;
        for (int i = len - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1])
                continue;
            if (arr[i] < arr[len - 1]) {
                reverse(arr, i + 1);
                reverse(arr, i);
                continue;
            }

            int j = i + 1;

            while (j != len - 1 && arr[i] < arr[j]) j++;
            reverse(arr, j);
            reverse(arr, i + 1);
            reverse(arr, i);
            reverse(arr, j - 1);
        }
        return arr;
    }

    public static void reverse(int[] arr, int lo) {
        int hi = arr.length - 1;
        int mid = (lo + hi) / 2;
        while (lo <= mid) {
            int temp = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = temp;
            lo++;
            hi--;
        }
    }
}
