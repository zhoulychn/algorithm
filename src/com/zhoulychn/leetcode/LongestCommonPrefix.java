package com.zhoulychn.leetcode;

/*

编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z 。

 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) return "";

        if (strs.length == 1) return strs[0];

        StringBuilder common = new StringBuilder(strs[0]);

        for (String item : strs) {

            //如果当前公共串长于当前单词，后面的字符则删除
            if (common.length() > item.length()) {
                common.delete(item.length(), common.length());
            }

            //遍历公共串，发现不一样的位置，则从此处删除，并跳出当前单词
            for (int j = 0; j < common.length(); j++) {
                if (item.charAt(j) != common.charAt(j)) {
                    common.delete(j, common.length());
                    if (common.length() == 0) return "";
                    break;
                }
            }
        }
        return common.toString();
    }

    public static void main(String[] args) {
        String s = new LongestCommonPrefix().longestCommonPrefix(new String[]{"ab", "aa"});
        System.out.println(s);
    }
}
