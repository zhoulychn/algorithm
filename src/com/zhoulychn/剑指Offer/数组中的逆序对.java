package com.zhoulychn.剑指Offer;

/*

在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007

 */
public class 数组中的逆序对 {
    public int InversePairs(int[] array) {
        int count = 0;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i] < array[j]) count = (count + 1) % 1000000007;
            }
        }
        return count;
    }
}
