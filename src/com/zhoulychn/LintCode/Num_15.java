package com.zhoulychn.LintCode;

import org.junit.Test;

import java.util.*;

/**
 * Created by Lewis on 2018/3/7
 */
public class Num_15 {

    private List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        for (int i : nums) {
            if (result.size() == 0) {
                result.add(new LinkedList<Integer>());
                result.get(0).add(nums[0]);
                continue;
            }
            List<List<Integer>> array = new ArrayList<>();
            for (List<Integer> each : result) {
                for (int j = 0; j <= each.size(); j++) {
                    LinkedList<Integer> list = new LinkedList<>(each);
                    list.add(j, i);
                    array.add(list);
                }
            }
            result.clear();
            result = array;
        }
        return result;
    }


    @Test
    public void run() {
        int[] arr = {0, 1};
        List<List<Integer>> permute = permute(arr);
    }
}