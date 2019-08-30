package com.zhoulychn.剑指Offer;

/*

一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。

 */
public class 青蛙跳台阶II {

    // dp[n] = d[n-1],dp[n-2],...,dp[0]
    public int JumpFloorII(int target) {
        if (target <= 2) return target;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= target; i++) {
            int v = 0;
            for (int j = 0; j < i; j++) {
                v += dp[j];
            }
            dp[i] = v;
        }
        return dp[target];
    }
}
