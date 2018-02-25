package com.zhoulychn.LintCode;

//在数组中找到第k大的元素

import com.zhoulychn.BaseBean.StackAndQueue.SqStack;
import com.zhoulychn.Utils.StackUtils;

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

    private int partition(int k, int[] nums, int lo, int hi) {

        SqStack stack = new SqStack(1024);

        StackUtils.push(stack, hi);

        StackUtils.push(stack, lo);
        
        int pivot = 0;

        while (!StackUtils.isEmpty(stack)) {

            int low = StackUtils.pop(stack), high = StackUtils.pop(stack),last = high;

            pivot = nums[low];

            while (low < high) {
                while (low < high && nums[high] >= pivot) high--;
                nums[low] = nums[high];
                while (low < high && nums[low] <= pivot) low++;
                nums[high] = nums[low];
            }

            nums[low] = pivot;

            if (last - low + 1 > k) {
                StackUtils.push(stack, last);
                StackUtils.push(stack, low + 1);
                continue;
            }
            if (last - low + 1 < k) {
                k -= last - low + 1;
                StackUtils.push(stack, low - 1);
                StackUtils.push(stack, 0);
                continue;
            }
            break;
        }
        return pivot;
    }
}
