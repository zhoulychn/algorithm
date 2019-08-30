package com.zhoulychn.剑指Offer;

import com.zhoulychn.common.tree.TreeNode;

public class 镜像二叉树 {

    public void Mirror(TreeNode root) {
        if (root == null) return;
        Mirror(root.left);
        Mirror(root.right);
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
    }
}
