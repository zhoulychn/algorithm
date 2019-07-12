package com.zhoulychn.leetcode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

示例 1:

输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:

输入: nums = [1], k = 1
输出: [1]
说明：

你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 */
public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 1) {
            result.add(nums[0]);
            return result;
        }

        //key为数，value为次数
        Map<Integer, Integer> frequent = new HashMap<>();
        for (int num : nums) {
            frequent.putIfAbsent(num, 0);
            frequent.put(num, frequent.get(num) + 1);
        }

        //遍历map，加入list，按次数排序
        for (Map.Entry<Integer, Integer> entry : frequent.entrySet()) {
            result.add(entry.getKey());
            for (int i = result.size() - 1; i > 0; i--) {
                if (frequent.get(result.get(i)) > frequent.get(result.get(i - 1))) {
                    int temp = result.get(i - 1);
                    result.set(i - 1, result.get(i));
                    result.set(i, temp);
                }
            }
        }

        //删除次数k之后的数
        for (int i = result.size() - 1; i >= k; i--) {
            result.remove(i);
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> integers = new TopKFrequentElements().topKFrequent(new int[]{-1, 1}, 1);

        System.out.println(integers);
    }
}
