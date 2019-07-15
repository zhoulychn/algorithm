package com.zhoulychn.leetcode;

public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        int low = 0, high = nums.length - 1;
        while (true) {

            int index = partition(nums, high, low);

            //比较枢轴后半部的元素数量，大于查找元素的排名，对后半部划分，小于查找元素的排名，重置K(减去后半部数量)然后对前半部划分。
            if (high - index + 1 > k) {
                low = index + 1;
            } else if (high - index + 1 < k) {
                k -= high - index + 1;
                high = index - 1;
            } else {
                return nums[index];
            }
        }
    }

    // 快速排序划分操作
    private int partition(int[] nums, int high, int low) {
        int pivot = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= pivot) high--;
            nums[low] = nums[high];
            while (low < high && nums[low] <= pivot) low++;
            nums[high] = nums[low];
        }
        nums[low] = pivot;
        return low;
    }
}
