package com.zhoulychn.leetcode;

import com.zhoulychn.common.tree.TreeNode;

import java.util.Stack;

/*

给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。

说明：
你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。

示例 1:

输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 1
示例 2:

输入: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
输出: 3
进阶：
如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？

 */
public class KthSmallestElementInABst {

    // 二叉搜索树 中序遍历是大小顺序
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || stack.size() != 0) {

            // 左边全部入栈
            if (p != null) {
                stack.push(p);
                p = p.left;
            }

            // 出栈，左中先，然后指向右边
            else {
                p = stack.pop();
                if (--k == 0) return p.val;
                p = p.right;
            }
        }
        return -1;
    }
}
