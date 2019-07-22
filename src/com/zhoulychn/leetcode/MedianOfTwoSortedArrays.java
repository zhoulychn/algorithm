package com.zhoulychn.leetcode;

/*

给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。

示例 1:

nums1 = [1, 3]
nums2 = [2]

则中位数是 2.0
示例 2:

nums1 = [1, 2]
nums2 = [3, 4]

则中位数是 (2 + 3)/2 = 2.5

 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return findMedianSortedArrays(nums1, nums2, 0, nums1.length - 1, 0, nums2.length - 1);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2, int lo1, int hi1, int lo2, int hi2) {
        if (hi1 == lo1 && hi2 == lo2) return (nums1[lo1] + nums2[lo2]) / 2.0;
        int m1 = (hi1 - lo1) / 2;
        int m2 = (hi2 - lo2) / 2;
        int v1 = hi1 - lo1 % 2 == 0 ? nums1[m1] : (nums1[m1] + nums1[m1 + 1]) / 2;

        if (nums1[m1] > nums2[m2]) {
            hi1 = m1;
            if (hi2 - lo2 % 2 == 0) lo2 = m2;
            else lo2 = m2 + 1;
        } else {
            hi2 = m2;
            if (hi1 - lo1 % 2 == 0) lo1 = m1;
            else lo1 = m1 + 1;
        }
        return findMedianSortedArrays(nums1, nums2, lo1, hi1, lo2, hi2);
    }

    public static void main(String[] args) {
        double medianSortedArrays = new MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        System.out.println(medianSortedArrays);
    }

}
