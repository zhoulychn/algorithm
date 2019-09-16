package com.zhoulychn.剑指Offer;

import com.zhoulychn.common.tree.TreeNode;

import java.util.Stack;

public class 二叉搜索树中的第k个节点 {

    TreeNode KthNode(TreeNode pRoot, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (pRoot != null || stack.size() != 0) {
            if (pRoot != null) {
                stack.push(pRoot);
                pRoot = pRoot.left;
            } else {
                TreeNode node = stack.pop();
                if (--k == 0) return node;
                pRoot = node.right;
            }
        }
        return null;
    }
}
