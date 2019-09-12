package com.zhoulychn.leetcode;

public class CoinChange2 {

    public int change(int amount, int[] coins) {
        int[] ops = new int[amount + 1];
        ops[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                ops[i] += ops[i - coin];
            }
        }
        return ops[amount];
    }
}
