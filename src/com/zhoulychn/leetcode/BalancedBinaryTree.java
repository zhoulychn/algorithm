package com.zhoulychn.leetcode;

import com.zhoulychn.common.tree.TreeNode;

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int l = calc(root.left);
        int r = calc(root.right);
        if (Math.abs(l - r) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int calc(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(calc(root.left), calc(root.right));
    }
}
