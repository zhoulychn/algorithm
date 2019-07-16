package com.zhoulychn.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

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
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        backtrack(res, nums, 0);
        return res;
    }

    public void backtrack(List<List<Integer>> res, int[] nums, int i) {
        if (i >= nums.length) return;

        //迭代器遍历可以新增删除元素
        ListIterator<List<Integer>> iterator = res.listIterator();

        while (iterator.hasNext()) {

            //取出当前要并入数的数组，然后在结果中删除原数组
            List<Integer> item = iterator.next();
            iterator.remove();

            //先加上末尾
            ArrayList<Integer> temp = new ArrayList<>(item);
            temp.add(nums[i]);
            iterator.add(temp);

            //循环在中间插入值
            for (int j = 0; j < item.size(); j++) {
                temp = new ArrayList<>(item);
                temp.add(j, nums[i]);
                iterator.add(temp);
            }
        }
        backtrack(res, nums, ++i);
    }

    public static void main(String[] args) {
        List<List<Integer>> permute = new Permutations().permute(new int[]{1, 2, 3});
    }
}
