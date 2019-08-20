package com.zhoulychn.leetcode;

import java.util.HashMap;
import java.util.Map;

/*

给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。

返回可以使最终数组和为目标数 S 的所有添加符号的方法数。

示例 1:

输入: nums: [1, 1, 1, 1, 1], S: 3
输出: 5
解释:

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

一共有5种方法让最终目标和为3。
注意:

数组的长度不会超过20，并且数组中的值全为正数。
初始的数组的和不会超过1000。
保证返回的最终结果为32位整数。

 */
public class TargetSum {

    public int findTargetSumWays(int[] nums, int S) {
        return find(nums, nums.length - 1, S);
    }

    private int find(int[] nums, int i, int s) {
        if (i < 0) return s == 0 ? 1 : 0;
        return find(nums, i - 1, s - nums[i]) + find(nums, i - 1, s + nums[i]);
    }

    public static void main(String[] args) {
        int targetSumWays = new TargetSum().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println(targetSumWays);
    }
}
