package com.zhoulychn.LintCode;

//在数组中找到第k大的元素

import com.zhoulychn.BaseBean.StackAndQueue.SqStack;
import org.junit.Test;

public class Num_5 {


    //递归也可以实现，但是数据量大就会栈溢出
    private int kthLargestElement(int k, int[] nums) {

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

    /**
     * 快速排序划分操作
     *
     * @param nums 数组
     * @param high 尾部
     * @param low  首部
     * @return 枢轴位置
     */
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


    @Test
    public void run() {
        int[] nums = {2, 10, 6, 4, 22, 1, 34, 23, 18, 7};
        int k = 4;
        int i = kthLargestElement(k, nums);
        System.out.println(i);
    }
}
