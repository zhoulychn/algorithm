package com.zhoulychn.leetcode;


/*
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4],
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {

        // 特殊情况
        if (nums.length < 2) return nums.length == 1 ? nums[0] : 0;

        // result是结果，sum是缓存局部的和
        int result = nums[0], sum = nums[0] > 0 ? 0 : nums[0];

        for (int num : nums) {

            // 当出现负数时，sum会有变小的趋势，所以此时sum是局部最大的，先把结果放到result
            if (num < 0) {
                result = Math.max(result, sum);
            }

            // 局部和，取 当前数 或 加上之前 更大值。
            sum = Math.max(num, sum + num);
        }

        // 当sum一直变大到最后时，result可能没取过sum的值，所以要判断
        return Math.max(result, sum);
    }
}
