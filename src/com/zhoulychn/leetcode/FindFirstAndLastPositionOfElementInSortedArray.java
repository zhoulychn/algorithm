package com.zhoulychn.leetcode;

/*

给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 O(log n) 级别。

如果数组中不存在目标值，返回 [-1, -1]。

示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
示例 2:

输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]

 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};

        int lo = 0, hi = nums.length - 1;
        int mid = 0;

        // 判断加上等于
        while (lo <= hi) {
            mid = (lo + hi) >>> 1;
            if (nums[mid] > target) hi = mid - 1;
            else if (nums[mid] < target) lo = mid + 1;
            else break;
        }

        // 判断最后的mid处是否为目标值
        if (nums[mid] != target) return new int[]{-1, -1};

        // 寻找开始和结束
        int start = mid, end = mid;

        while (start >= 0 && nums[start] == target) start--;

        while (end < nums.length && nums[end] == target) end++;

        return new int[]{++start, --end};
    }

    public static void main(String[] args) {
        int[] ints = new FindFirstAndLastPositionOfElementInSortedArray().searchRange(new int[]{1, 4}, 4);
    }
}
