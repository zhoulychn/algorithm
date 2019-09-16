package com.zhoulychn.剑指Offer;

public class 数字在排序数组中出现的次数 {

    public int GetNumberOfK(int[] array, int k) {
        if (array.length == 0) return 0;
        int lo = 0, hi = array.length - 1;

        int mid = 0;
        while (lo <= hi) {
            mid = (lo + hi) >> 1;
            if (array[mid] > k) {
                hi = mid - 1;
            } else if (array[mid] < k) {
                lo = mid + 1;
            } else break;
        }
        if (array[mid] != k) return 0;
        int start = mid, end = mid;
        for (int i = mid; i >= 0; i--) {
            if (array[i] == k) start = i;
        }
        for (int i = mid; i < array.length; i++) {
            if (array[i] == k) end = i;
        }
        return end - start + 1;
    }
}
