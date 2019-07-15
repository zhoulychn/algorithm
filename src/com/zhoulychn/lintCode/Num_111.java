package com.zhoulychn.lintCode;

/**
 * Created by Lewis on 2018/3/2
 *
 * 假设你正在爬楼梯，需要n步你才能到达顶部。但每次你只能爬一步或者两步，你能有多少种不同的方法爬到楼顶部？
 */
public class Num_111 {

    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        if (n == 0) return 0;
        int[] result = new int[n + 1];
        result[0] = result[1] = 1;
        for (int i = 2; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n];
    }
}
