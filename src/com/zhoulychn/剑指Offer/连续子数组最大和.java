package com.zhoulychn.剑指Offer;

public class 连续子数组最大和 {

    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 1) return array[0];
        int result = array[0], sum = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < 0) result = Math.max(result, sum);
            sum = Math.max(array[i], sum + array[i]);
        }
        return Math.max(result, sum);
    }
}
