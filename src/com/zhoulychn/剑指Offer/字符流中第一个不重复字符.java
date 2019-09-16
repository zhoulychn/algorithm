package com.zhoulychn.剑指Offer;

import java.util.LinkedHashMap;
import java.util.Map;

public class 字符流中第一个不重复字符 {

    LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();

    public void Insert(char ch) {
        map.putIfAbsent(ch, 0);
        map.put(ch, map.get(ch) + 1);
    }

    public char FirstAppearingOnce() {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();
        }
        return '#';
    }
}
