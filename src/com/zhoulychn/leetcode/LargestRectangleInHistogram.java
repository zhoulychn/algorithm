package com.zhoulychn.leetcode;

import java.util.Stack;

/*

给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

求在该柱状图中，能够勾勒出来的矩形的最大面积。

以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。


图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。

示例:

输入: [2,1,5,6,2,3]
输出: 10

 */
public class LargestRectangleInHistogram {

    // 递增栈，时间复杂度O(n)
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        // 当前数大于栈顶，索引入栈，不大于，则把之前所有大的索引全部出栈，并计算栈顶和当前索引之间的面积
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                max = Math.max(max, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }

        //如果栈不空，全部出栈计算
        while (stack.peek() != -1) {
            max = Math.max(max, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return max;
    }


    // 分治,找到当前最小值构成的面积，然后分别计算最小值左边和右边的面积，时间复杂度O(nlogn)
    public int calculateArea(int[] heights) {
        return partition(heights, 0, heights.length - 1);
    }

    public int partition(int[] heights, int lo, int hi) {
        if (lo > hi)
            return 0;
        int min = lo;
        for (int i = lo + 1; i <= hi; i++) min = heights[min] < heights[i] ? min : i;
        return Math.max(heights[min] * (hi - lo + 1), Math.max(partition(heights, lo, min - 1), partition(heights, min + 1, hi)));
    }

    public static void main(String[] args) {
        int i = new LargestRectangleInHistogram().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
        System.out.println(i);
    }
}
