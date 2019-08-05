package com.zhoulychn.leetcode;

import com.zhoulychn.Tools;
import com.zhoulychn.common.tree.TreeNode;

/*

给定一个非空二叉树，返回其最大路径和。

本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。

示例 1:

输入: [1,2,3]

       1
      / \
     2   3

输出: 6
示例 2:

输入: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

输出: 42

 */
public class BinaryTreeMaximumPathSum {

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        this.recursion(root);
        return max;
    }

    public int recursion(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(recursion(root.left), 0);
        int right = Math.max(recursion(root.right), 0);

        // 以此节点为根，比较最大值
        max = Math.max(root.val + right + left, max);

        // return 之后是作为左子树或者右子树，所以取较大的一边当作一半的路径
        return root.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        new BinaryTreeMaximumPathSum().maxPathSum(Tools.build(new Integer[]{1, 2, 3}, 0));
    }
}
