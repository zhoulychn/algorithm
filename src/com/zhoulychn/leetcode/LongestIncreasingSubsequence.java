package com.zhoulychn.leetcode;

/*

给定一个无序的整数数组，找到其中最长上升子序列的长度。

示例:

输入: [10,9,2,5,3,7,101,18]
输出: 4
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
说明:

可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
你算法的时间复杂度应该为 O(n2) 。
进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?

 */

public class LongestIncreasingSubsequence {


    // 动态规划，ops[i]保存包含nums[i]的最大长度
    public int lengthOfLIS(int[] nums) {

        if (nums.length < 2) return nums.length;
        int[] ops = new int[nums.length];
        ops[0] = 1;
        int max = 1;

        // 循环求每个位置的最大长度
        for (int i = 1; i < nums.length; i++) {

            // 初始化为1
            ops[i] = 1;

            // 比较之前的最大长度，如果比之前值的更大，长度为该值的长度+1，更新最大值
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) ops[i] = Math.max(ops[i], ops[j] + 1);
            }

            // 记录结果
            max = Math.max(max, ops[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int i = new LongestIncreasingSubsequence().lengthOfLIS(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6});
    }

}
