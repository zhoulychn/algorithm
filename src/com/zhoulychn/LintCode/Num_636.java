package com.zhoulychn.LintCode;

//给你一个 n 个整数的序列 a1,a2,...,an，一个 132 模式是对于一个子串 ai,aj,ak，满足 i < j < k 和 ai < ak < aj。

//设计一个算法来检查输入的这 n 个整数的序列中是否存在132模式。

//n 会小于 20,000。

import org.junit.Test;

public class Num_636 {

    public boolean find132pattern(int[] list) {
        for (int i = 0; i < list.length - 2 && i<19998; i++) {
            int first = list[i], second = list[i + 1], third = list[i + 2];
            if (first < third && third < second) return true;
        }
        return false;
    }

    @Test
    public void run() {
        int[] list = new int[]{1, 5, 2, 4, 6, 8, 7};

        System.out.println(list.length);
    }
}
