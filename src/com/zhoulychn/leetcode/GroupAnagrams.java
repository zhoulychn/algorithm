package com.zhoulychn.leetcode;

import java.util.*;

/*

给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
说明：

所有输入均为小写字母。
不考虑答案输出的顺序。

 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        List<List<String>> res = new LinkedList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);

            // 当前串不存在相同构成，重现构建一个list，放入map和res
            if (map.get(key) == null) {
                map.put(key, new LinkedList<>());
                res.add(map.get(key));
            }

            // list添加当前串
            map.get(key).add(str);
        }
        return res;
    }
}
