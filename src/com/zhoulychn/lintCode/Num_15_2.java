package com.zhoulychn.lintCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lewis on 2018/3/9
 */
public class Num_15_2 {


    public List<List<Integer>> result = new ArrayList<>();
    public ArrayList<Integer> currArray = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        ArrayList<Integer> numsArray = new ArrayList<>();
        for (int i : nums) {
            numsArray.add(i);
        }
        Helper(numsArray);
        return result;
    }

    private void Helper(ArrayList<Integer> numsArray) {
        if (numsArray.size() == 0) {
            result.add(new ArrayList<Integer>(currArray));
            currArray.remove(currArray.size() - 1);
            return;
        }
        for (int i = 0; i < numsArray.size(); i++) {
            currArray.add(numsArray.get(i));
            ArrayList<Integer> numsLeft = new ArrayList<Integer>(numsArray);
            numsLeft.remove(i);
            Helper(numsLeft);
        }
        if (currArray.size() > 0) {
            currArray.remove(currArray.size() - 1);
        }
        return;
    }

    @Test
    public void run() {
        List<List<Integer>> permute = permute(new int[]{1, 2, 3, 4});
    }
}
