package com.zhoulychn.utils;

public class SortUtils {

    public static void insertSort(int[] A) {
        for (int i = 1; i < A.length; i++) {
            int temp = A[i];
            int j = i - 1;
            while (j >= 0 && temp <= A[j]) {
                A[j + 1] = A[j];
                j--;
            }
            A[j + 1] = temp;
        }
    }
}
