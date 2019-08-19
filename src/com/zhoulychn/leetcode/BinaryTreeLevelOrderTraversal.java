package com.zhoulychn.leetcode;

import com.zhoulychn.Tools;
import com.zhoulychn.common.stack.SqQueue;
import com.zhoulychn.common.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*

给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]

 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        TreeNode p = root;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        res.add(temp);
        while (queue.size() != 0) {
            TreeNode node = queue.poll();
            temp.add(node.val);
            if (node.left != null) queue.addLast(node.left);
            if (node.right != null) queue.addLast(node.right);
            if (node == p && queue.size() != 0) {
                p = queue.peekLast();
                temp = new ArrayList<>();
                res.add(temp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new BinaryTreeLevelOrderTraversal().levelOrder(Tools.init(new Integer[]{3, 9, 20, null, null, 15, 7}));
    }
}
