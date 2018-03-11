package com.zhoulychn.LintCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lewis on 2018/3/8
 * <p>
 * 给定一个含不同整数的集合，返回其所有的子集
 */


public class Num_17 {


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        if (nums.length == 0) {
            return result;
        }
        for (int i : nums) {
            int size = result.size();
            for (int j = size - 1; j >= 0; j--) {
                result.add(new LinkedList<>(result.get(j)));
                result.get(result.size() - 1).add(i);
            }
        }
        return result;
    }

    @Test
    public void run() {
        List<List<Integer>> subsets = subsets(new int[]{4, 1, 0});
        System.out.println(subsets);
    }
}
