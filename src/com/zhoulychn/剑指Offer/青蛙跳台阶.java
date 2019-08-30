package com.zhoulychn.剑指Offer;

/*

一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。

 */
public class 青蛙跳台阶 {

    public int JumpFloor(int target) {
        if (target <= 2) return target;

        int s = 1, t = 2;
        for (int i = 3; i <= target; i++) {
            int v = s + t;
            s = t;
            t = v;
        }
        return t;
    }
}
