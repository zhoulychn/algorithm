package com.zhoulychn.leetcode;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 注意：给定 n 是一个正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * <p>
 * 示例 2：
 * <p>
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class ClimbingStairs {

    // 递归求解，n层台阶等于上一步或两步的解法和。容易栈溢出或超时。
    private int climbStairs(int n) {
        return (n == 1 || n == 2) ? n : climbStairs(n - 1) + climbStairs(n - 2);
    }

    //动态规划，用数组保存前面的结果
    private int climbStairs2(int n) {
        if (n <= 1) return 1;   //边界处理
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr[n];
    }


    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs2(10));
    }


}
