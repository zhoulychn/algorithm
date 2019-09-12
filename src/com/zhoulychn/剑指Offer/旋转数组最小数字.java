package com.zhoulychn.剑指Offer;

public class 旋转数组最小数字 {


    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) return 0;
        int lo = 0, hi = array.length - 1;
        while (true) {
            // 如果low和high中间只有一个元素，则必为最小值
            if (hi - lo == 1) return array[hi];
            int mid = (lo + hi) >> 1;
            if (array[mid] < array[hi]) {

                //此时mid小于第二段的最大值，说明位于第二段中，如果此元素也小于左边元素，则为最小值
                if (array[mid] < array[mid - 1]) return array[mid];
                hi = mid - 1;
            }
            //mid元素大于第二段的最大值，说明mid在第一段，需要右移一位。
            else lo += 1;
        }
    }
}
