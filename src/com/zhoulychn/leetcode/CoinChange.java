package com.zhoulychn.leetcode;

/*
给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

示例 1:

输入: coins = [1, 2, 5], amount = 11
输出: 3
解释: 11 = 5 + 5 + 1
示例 2:

输入: coins = [2], amount = 3
输出: -1
说明:
你可以认为每种硬币的数量是无限的。
 */

public class CoinChange {


    // 动态规划状态转移方程：f(n) = min{ f(n-c1)+1, f(n-c2)+1, f(n-c3)+1, f(n-c4)+1... }， n-c=0时，f(n-c)=1;
    public int coinChange(int[] coins, int amount) {

        if (amount == 0) return 0;

        int[] ops = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {

            int min = Integer.MAX_VALUE;

            for (int coin : coins) {
                if (i - coin == 0) {
                    min = 1;
                    break;
                }
                if (i - coin > 0 && ops[i - coin] != -1) min = Math.min(min, ops[i - coin] + 1);
            }
            ops[i] = min == Integer.MAX_VALUE ? -1 : min;
        }
        return ops[amount];
    }

    public static void main(String[] args) {
        int i = new CoinChange().coinChange(new int[]{2}, 3);
        System.out.println(i);
    }
}
