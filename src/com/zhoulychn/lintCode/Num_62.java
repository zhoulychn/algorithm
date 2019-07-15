package com.zhoulychn.lintCode;

import org.junit.Test;

/**
 * Created by Lewis on 2018/3/8
 */
public class Num_62 {

    private int searchMin(int[] A) {
        if (A.length == 1) return A[0];
        int low = 0, high = A.length - 1;
        while (true) {
            if (high - low == 1) return A[high];
            int mid = low + (high - low) / 2;
            int pivot = A[mid];
            if (pivot > A[high]) {
                low += 1;
                continue;
            }
            if (pivot < A[mid - 1])
                return pivot;
            high = mid - 1;
        }
    }

    private int search(int[] arr, int target) {
        return -1;
    }

    @Test
    public void run() {
        int i = searchMin(new int[]{2});
        System.out.println(i);
    }
}
