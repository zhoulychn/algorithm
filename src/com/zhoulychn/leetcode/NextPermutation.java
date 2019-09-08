package com.zhoulychn.leetcode;

import java.util.Arrays;
import java.util.Collections;

public class NextPermutation {


    // 从后向前，与上一个元素比较，直到当前元素nums[i]大于上一个元素nums[i-1]，从i先后找把最后一个大于上一个元素的值nums[j]，交换i-1和j，然后从i到最后逆置。
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] <= nums[i - 1]) continue;
            int j = i;
            while (j + 1 < nums.length && nums[j + 1] > nums[i - 1]) j += 1;
            int temp = nums[i - 1];
            nums[i - 1] = nums[j];
            nums[j] = temp;
            for (int k = i, z = nums.length - 1; k < z; k++, z--) {
                temp = nums[k];
                nums[k] = nums[z];
                nums[z] = temp;
            }
            return;
        }
        Arrays.sort(nums);
    }
}
