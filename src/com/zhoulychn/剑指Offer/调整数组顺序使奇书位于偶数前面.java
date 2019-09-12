package com.zhoulychn.剑指Offer;

/*

输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分
所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。

 */
public class 调整数组顺序使奇书位于偶数前面 {

    public void reOrderArray(int[] array) {

        // 记录偶数的长度
        int len = 0;
        for (int i = 0; i < array.length; i++) {

            // 偶数长度增加
            if (array[i] % 2 == 0) {
                len++;
                continue;
            }

            // 如果是奇书，前面没有偶数，不用处理
            if (len == 0) continue;

            // 前面有偶数，如 2 4 7， len为2，len长度的偶数先后移，最后把奇书放到最前面
            int value = array[i];

            for (int j = i; j >= i - len + 1; j--) {
                array[j] = array[j - 1];
            }
            array[i - len] = value;
        }
    }
}
