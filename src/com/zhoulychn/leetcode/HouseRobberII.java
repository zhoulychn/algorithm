package com.zhoulychn.leetcode;

/*

你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。

示例 1:

输入: [2,3,2]
输出: 3
解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
示例 2:

输入: [1,2,3,1]
输出: 4
解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     偷窃到的最高金额 = 1 + 3 = 4 。

 */
public class HouseRobberII {

    public int rob(int[] nums) {

        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);


        int last = nums.length - 1;

        // ops1为[0,n-1]的最好选择
        int[] ops1 = new int[nums.length];

        // ops1为[1,n]的最好选择
        int[] ops2 = new int[nums.length];

        // 初始化ops1的0
        ops1[0] = nums[0];

        // 遍历[1,n]
        for (int i = 1; i < last; i++) {

            // ops1的起始夜为[0]夜，所以i-2大于等于0
            ops1[i] = Math.max((i - 2 < 0 ? 0 : ops1[i - 2]) + nums[i], ops1[i - 1]);

            // ops1的起始夜为[0]夜，所以i-2大于等于1
            ops2[i] = Math.max((i - 2 < 1 ? 0 : ops2[i - 2]) + nums[i], ops2[i - 1]);
        }

        // 初始化ops2的n
        ops2[last] = +Math.max(last - 2 < 1 ? 0 : ops2[last - 2] + nums[last], ops2[last - 1]);
        return Math.max(ops1[last - 1], ops2[last]);
    }

    public static void main(String[] args) {
        int rob = new HouseRobberII().rob(new int[]{2, 3, 2});
    }
}
