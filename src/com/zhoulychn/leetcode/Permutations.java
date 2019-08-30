package com.zhoulychn.leetcode;

import java.util.*;

/*
给定一个没有重复数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */
public class Permutations {

    // 每次并入一个数，在之前的数之间插入值，比如[1,2]之间插入3，得到[3,1,2][1,3,2][1,2,3]
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new LinkedList<>();

        res.add(new LinkedList<>());

        for (int i = 0; i < nums.length; i++) {

            // 当前res大小，需要并入数字的范围
            int size = res.size();

            for (int j = 0; j < size; j++) {

                // 当前并入的数列
                List<Integer> cur = res.get(j);

                // 分别在空位插入值
                for (int k = 0; k <= cur.size(); k++) {
                    List<Integer> temp = new LinkedList<>(cur);
                    temp.add(k, nums[i]);
                    res.add(temp);
                }
            }

            // 使用完成，删除
            for (int j = 0; j < size; j++) {
                res.remove(0);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        List<List<Integer>> permute = new Permutations().permute(new int[]{1, 2, 3});
    }
}
