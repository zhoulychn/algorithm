package com.zhoulychn.LintCode;

//在数组中找到第k大的元素

import com.zhoulychn.BaseBean.StackAndQueue.SqStack;
import com.zhoulychn.Utils.StackUtils;
import org.junit.Test;

public class Num_5 {

    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {

        int low = 0, high = nums.length - 1;

        return partition(k, nums, low, high);
    }

    //递归也可以实现，但是数据量大就会栈溢出
    private int partition(int k, int[] nums, int lo, int hi) {

        SqStack<Integer> stack = new SqStack<Integer>(1024);

        stack.push(hi);

        stack.push(lo);

        int pivot = 0;

        while (!stack.isEmpty()) {

            //last 用于保存每次划分开始的上界

            int low = stack.pop(), high = stack.pop(), last = high;

            pivot = nums[low];

            while (low < high) {
                while (low < high && nums[high] >= pivot) high--;
                nums[low] = nums[high];
                while (low < high && nums[low] <= pivot) low++;
                nums[high] = nums[low];
            }

            nums[low] = pivot;

            //比较枢轴后半部的元素数量，大于查找元素的排名，对后半部划分，小于查找元素的排名，重置K(减去后半部数量)然后对前半部划分。

            if (last - low + 1 > k) {
                stack.push(last);
                stack.push(low + 1);
                continue;
            }
            if (last - low + 1 < k) {
                k -= last - low + 1;
                stack.push(low - 1);
                stack.push(0);
                continue;
            }
            break;
        }
        return pivot;
    }

    @Test
    public void run() {
        int[] nums = {1, 2, 3, 4, 5, 6, 8, 9, 10, 7};
        int k = 10;
        int i = kthLargestElement(k, nums);
        System.out.println(i);
    }
}
