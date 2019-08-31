package com.zhoulychn.leetcode;

public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        int lo = 0, hi = nums.length - 1;

        //比较枢轴后半部的元素数量，大于查找元素的排名，对后半部划分，小于查找元素的排名，重置K(减去后半部数量)然后对前半部划分。
        while (true) {
            int i = partition(nums, lo, hi);

            // hi - i + 1为最后元素到i元素的长度，长度等于k，说明i元素就是第k大
            int len = hi - i + 1;

            // 后半段长度不够，k减去后半段长度
            if (len < k) {
                k -= len;
                hi = i - 1;
            } else if (len > k) lo = i + 1;
            else return nums[i];
        }
    }

    // 快速排序划分操作
    private int partition(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        while (lo < hi) {
            while (lo < hi && nums[hi] >= pivot) hi--;
            nums[lo] = nums[hi];
            while (lo < hi && nums[lo] <= pivot) lo++;
            nums[hi] = nums[lo];
        }
        nums[lo] = pivot;
        return lo;
    }
}
