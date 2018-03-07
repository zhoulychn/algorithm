package com.zhoulychn.LintCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Lewis on 2018/3/3
 * <p>
 * 给定一个整数数组，找到一个具有最大和的子数组，返回其最大和。
 */
public class Num_41 {

    private int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int result = nums[0], sum = nums[0] < 0 ? nums[0] : 0;
        for (int num : nums) {
            if (num < 0){
                result = Math.max(result, sum);
            }
            sum = Math.max(num, sum + num);
        }
        return Math.max(result, sum);
    }

    @Test
    public void run() {
        int[] nums = {-2, 2, -3, 4, -1, 2, 1, -5, 3};

        System.out.println(maxSubArray(nums));
    }
}
