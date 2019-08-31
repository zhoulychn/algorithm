package com.zhoulychn.leetcode;

import com.zhoulychn.Tools;
import com.zhoulychn.common.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

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
        TreeNode last = root;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        res.add(temp);
        while (queue.size() != 0) {
            TreeNode node = queue.poll();
            temp.add(node.val);
            if (node.left != null) queue.addLast(node.left);
            if (node.right != null) queue.addLast(node.right);

            // 当前出队节点是上一层的最后一个，说明此时下一层的所有节点已经全部入队，队尾为下一层最后一个节点

            // 一层元素全部添加，temp重新创建
            if (node == last && queue.size() != 0) {
                last = queue.peekLast();
                temp = new ArrayList<>();
                res.add(temp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new BinaryTreeLevelOrderTraversal().levelOrder(Tools.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7}));
    }
}
