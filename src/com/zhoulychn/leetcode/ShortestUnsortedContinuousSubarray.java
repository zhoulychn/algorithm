package com.zhoulychn.leetcode;

import sun.security.util.Length;

import java.util.Arrays;

/*

给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。

你找到的子数组应是最短的，请输出它的长度。

示例 1:

输入: [2, 6, 4, 8, 10, 9, 15]
输出: 5
解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
说明 :

输入的数组长度范围在 [1, 10,000]。
输入的数组可能包含重复元素 ，所以升序的意思是<=。

 */
public class ShortestUnsortedContinuousSubarray {

    //排序后，对比第一个不同的，和最后一个不同的元素
    public int findUnsortedSubarray(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(arr);
        int lo = 0, hi = 0;
        boolean l = false;
        boolean r = false;

        for (int i = 0, j = nums.length - 1; (!l || !r) && i < nums.length; i++, j--) {
            if (l && r) break;

            // 第一个左边不相等的
            if (!l && arr[i] != nums[i]) {
                lo = i;
                l = true;
            }

            // 第一个右边不相等的
            if (!r && arr[j] != nums[j]) {
                hi = j;
                r = true;
            }
        }

        // l为false全部相同，不需要对子数组排序
        return l ? hi - lo + 1 : 0;
    }

    public static void main(String[] args) {
        int unsortedSubarray = new ShortestUnsortedContinuousSubarray().findUnsortedSubarray(new int[]{1, 3, 2, 4, 5});
        System.out.println(unsortedSubarray);
    }
}
