package com.zhoulychn.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Tools {

    public static TreeNode build(Integer[] arr, int index) {
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
}
