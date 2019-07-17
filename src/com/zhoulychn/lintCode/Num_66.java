package com.zhoulychn.lintCode;

import com.zhoulychn.common.tree.TreeNode;

import java.util.*;

/**
 * 给出一棵二叉树，返回其节点值的前序遍历。
 */

public class Num_66 {

    /*
     * @param root: A tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }
}
