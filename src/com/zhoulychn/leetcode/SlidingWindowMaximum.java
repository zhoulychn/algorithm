package com.zhoulychn.leetcode;


import java.util.*;
import java.util.stream.IntStream;

/*
给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口 k 内的数字。滑动窗口每次只向右移动一位。

返回滑动窗口最大值。

示例:

输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7]
解释:

  滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
注意：

你可以假设 k 总是有效的，1 ≤ k ≤ 输入数组的大小，且输入数组不为空。

 */

@SuppressWarnings("all")
public class SlidingWindowMaximum {


    //每次滑动，一插入，一删除，插入被滑入的数，清除之前所有比这个数小的数，删除被滑过的数
    public int[] maxSlidingWindow(int[] nums, int k) {

        // 长度为0
        if (nums.length == 0) return new int[]{};

        // 长度为1
        if (nums.length == 1) return new int[]{nums[0]};

        // 最大值数组
        int[] maxArr = new int[nums.length - k + 1];

        // 最大值数组游标
        int index = 0;

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {

            // 放入数据
            push(deque, nums[i]);

            // 窗口还没填满时，放入不操作
            if (i < k - 1) continue;

            // 窗口每滑过一次，需要取一个最大值
            maxArr[index++] = deque.peek();


            // 窗口每滑过一次，需要删除队头（也就是废弃数据），但如果不是被窗口滑过的数据就不能删除
            if (deque.peek() == nums[i - k + 1]) deque.pollFirst();
        }
        return maxArr;
    }

    public void push(Deque<Integer> deque, int n) {

        // 加入一个数据，把之前最小的数据都删除
        // 因为当前数据更大，之前更小的数据没有比较的意义
        // 这样队列就保持了一个队头最大，队尾最小的排列
        while (deque.size() != 0 && deque.peekLast() < n) {
            deque.pollLast();
        }
        deque.addLast(n);
    }

    public static void main(String[] args) {
        int[] ints = new SlidingWindowMaximum().maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int num : ints) {
            System.out.println(num);
        }
    }
}
