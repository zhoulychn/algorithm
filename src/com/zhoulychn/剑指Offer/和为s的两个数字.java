package com.zhoulychn.剑指Offer;

/*

输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。

 */

import java.util.ArrayList;
import java.util.UnknownFormatConversionException;

public class 和为s的两个数字 {

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        int lo = 0, hi = array.length - 1;
        Integer v1 = null, v2 = null;
        while (lo < hi) {
            int left = array[lo];
            int right = array[hi];
            if (left + right > sum) hi--;
            else if (left + right < sum) lo++;
            else {
                lo++;
                if (v1 == null || v1 * v2 > left * right) {
                    v1 = left;
                    v2 = right;
                }
            }
        }


        ArrayList<Integer> result = new ArrayList<>();
        if (v1 == null) return result;
        result.add(v1);
        result.add(v2);
        return result;
    }
}
