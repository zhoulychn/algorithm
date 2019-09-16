package com.zhoulychn.剑指Offer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*

在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
并返回它的位置, 如果没有则返回 -1（需要区分大小写）.

 */
public class 只出现一次的字符 {

    public int FirstNotRepeatingChar(String str) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>(64);
        HashMap<Character, Integer> temp = new HashMap<>(64);
        for (int i = 0; i < str.length(); i++) {
            map.putIfAbsent(str.charAt(i), 0);
            map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            temp.putIfAbsent(str.charAt(i), i);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) return temp.get(entry.getKey());
        }
        return -1;
    }
}
