package com.zhoulychn.leetcode;

import com.zhoulychn.Tools;
import com.zhoulychn.common.tree.TreeNode;

import java.util.*;

/*

给定一个二叉树，检查它是否是镜像对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3
但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3

 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (queue.size() != 0) {
            if ((queue.getFirst() == null) != (queue.getLast() == null)) return false;
            if (queue.getFirst() == queue.getLast() || (queue.getFirst().val == queue.getLast().val)) {
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

    public static void main(String[] args) {
        new SymmetricTree().isSymmetric(Tools.init(new Integer[]{1, 2, 2, 3, 4, 4, 3}));
    }
}
