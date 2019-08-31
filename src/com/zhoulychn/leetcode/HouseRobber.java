package com.zhoulychn.leetcode;

import java.util.LinkedList;

/*

你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。

示例 1:

输入: [1,2,3,1]
输出: 4
解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     偷窃到的最高金额 = 1 + 3 = 4 。

示例 2:

输入: [2,7,9,3,1]
输出: 12
解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     偷窃到的最高金额 = 2 + 9 + 1 = 12 。

 */
public class HouseRobber {

    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];


        int[] ops = new int[nums.length];
        ops[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {

            // v为前夜（如果有前夜）和今夜的抢
            int v = nums[i] + (i - 2 >= 0 ? ops[i - 2] : 0);

            // ops[i-1]为昨夜的钱，判断哪个值更大
            ops[i] = +Math.max(v, ops[i - 1]);
        }
        return Math.max(ops[nums.length - 1], ops[nums.length - 2]);
    }

    public static void main(String[] args) {
        int rob = new HouseRobber().rob(new int[]{1, 2, 3});
        System.out.println(rob);
    }
}
