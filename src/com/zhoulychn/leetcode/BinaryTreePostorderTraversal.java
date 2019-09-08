package com.zhoulychn.leetcode;

import com.zhoulychn.common.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

/*

给定一个二叉树，返回它的 后序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [3,2,1]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？

 */
public class BinaryTreePostorderTraversal {


    // 求根右左，倒序就是后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) return result;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (stack.size() != 0) {
            TreeNode node = stack.pop();
            result.addFirst(node.val);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        return result;
    }

    public static void main(String[] args) {
    }
}
