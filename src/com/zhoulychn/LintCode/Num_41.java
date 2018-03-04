package com.zhoulychn.LintCode;

import java.util.ArrayList;

/**
 * Created by Lewis on 2018/3/3
 * <p>
 * 给定一个整数数组，找到一个具有最大和的子数组，返回其最大和。
 */
public class Num_41 {

    public int maxSubArray(int[] nums) {
        return 0;
    }

    private int search(int[] arr, int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= low; i--) {
            sum += arr[i];
            if (sum > leftSum) {
                leftSum = sum;
            }
        }
        return 0;
    }

    private int max(int a, int b, int c) {
        int temp = a > b ? a : b;
        return temp > c ? temp : c;
    }
}
