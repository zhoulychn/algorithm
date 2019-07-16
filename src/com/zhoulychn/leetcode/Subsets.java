package com.zhoulychn.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/*
给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 */
public class Subsets {

    //每次加入一个数，都在前面对应的子集加上
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int num : nums) {
            ListIterator<List<Integer>> iterator = res.listIterator();

            //迭代器过程中可以添加元素，并且不被访问到
            while (iterator.hasNext()) {
                List<Integer> item = iterator.next();
                ArrayList<Integer> temp = new ArrayList<>(item);
                temp.add(num);
                iterator.add(temp);
            }
        }
        return res;
    }



}
