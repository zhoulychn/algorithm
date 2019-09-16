package com.zhoulychn.剑指Offer;

import java.util.LinkedHashMap;
import java.util.Map;

public class 数组中的重复数字 {

    public boolean duplicate(int numbers[], int length, int[] duplication) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < length; i++) {
            int value = numbers[i];
            map.putIfAbsent(value, 0);
            map.put(value, map.get(value) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                duplication[0] = entry.getKey();
                return true;
            }
        }
        return false;
    }
}
