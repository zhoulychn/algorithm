package com.zhoulychn.剑指Offer;

import com.zhoulychn.common.tree.TreeNode;

public class 判断平衡二叉树 {

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) return true;
        int left = height(root.left);
        int right = height(root.right);
        if (Math.abs(left - right) > 1) return false;
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    public int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
