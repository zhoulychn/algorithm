package com.zhoulychn.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*

给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在众数。

 */
public class MajorityElement {

    // map记录次数，
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2) return entry.getKey();
        }
        return -1;
    }

    // 相同的数入栈，不同则出栈，如果一个数次数大于n/2，最后一定会剩下这个数
    public int majorityElement1(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            if (stack.size() != 0 && stack.peek() != num) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }
        return stack.peek();
    }
}
