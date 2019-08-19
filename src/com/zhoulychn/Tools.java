package com.zhoulychn;

import com.zhoulychn.common.tree.TreeNode;

public class Tools {

    public static TreeNode init(Integer[] arr) {
        return build(arr, 0);
    }

    private static TreeNode build(Integer[] arr, int index) {
        TreeNode node = null;
        if (index < arr.length) {
            Integer value = arr[index];
            if (value == null) {
                return null;
            }
            node = new TreeNode(value);
            node.left = build(arr, 2 * index + 1);
            node.right = build(arr, 2 * index + 2);
            return node;
        }
        return node;
    }

    public static String nameSwitch(String s) {

        StringBuilder sb = new StringBuilder(s);
        sb.replace(0, 1, ("" + s.charAt(0)).toUpperCase());


        for (int i = 1; i < s.length(); i++) {
            if (sb.charAt(i) == '-') sb.replace(i + 1, i + 2, ("" + s.charAt(i + 1)).toUpperCase());
        }
        return sb.toString().replace("-", "");
    }

    public static void main(String[] args) {
        String s = nameSwitch("palindromic-substrings");
        String str = "[[\"0\",\"0\",\"0\",\"1\"],[\"1\",\"1\",\"0\",\"1\"],[\"1\",\"1\",\"1\",\"1\"],[\"0\",\"1\",\"1\",\"1\"],[\"0\",\"1\",\"1\",\"1\"]]".replace("[", "{").replace("]", "}");
        System.out.println(s);
        System.out.println(str);
    }
}
