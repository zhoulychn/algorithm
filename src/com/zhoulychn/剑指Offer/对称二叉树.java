package com.zhoulychn.剑指Offer;

import com.zhoulychn.common.tree.TreeNode;

import java.util.LinkedList;

public class 对称二叉树 {

    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(pRoot.right);
        queue.addFirst(pRoot.left);
        while (!queue.isEmpty()) {
            if ((queue.getFirst() == null) != (queue.getLast() == null)) return false;
            if (queue.getFirst() == queue.getLast() || queue.getFirst().val == queue.getLast().val) {
                TreeNode left = queue.pollFirst();
                TreeNode right = queue.pollLast();
                if (left != null && right != null) {
                    queue.addFirst(left.right);
                    queue.addLast(right.left);
                    queue.addFirst(left.left);
                    queue.addLast(right.right);
                }
            } else return false;
        }
        return true;
    }
}
