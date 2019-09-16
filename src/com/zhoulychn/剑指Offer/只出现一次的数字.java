package com.zhoulychn.剑指Offer;

import java.util.HashMap;
import java.util.Map;

/*

一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。

 */
public class 只出现一次的数字 {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        HashMap<Integer, Integer> map = new HashMap<>(array.length);
        for (int i : array) {
            map.putIfAbsent(i, 0);
            map.put(i, map.get(i) + 1);
        }
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1 && i == 0) num1[i++] = entry.getKey();
            if (entry.getValue() == 1 && i == 1) num2[0] = entry.getKey();
        }
    }
}
