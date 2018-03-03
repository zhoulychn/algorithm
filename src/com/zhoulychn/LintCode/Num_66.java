package com.zhoulychn.LintCode;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;
import com.zhoulychn.BaseBean.StackAndQueue.SqQueue;
import com.zhoulychn.BaseBean.StackAndQueue.SqStack;
import com.zhoulychn.BaseBean.Tree.TreeNode;

import java.util.*;

/**
 * 给出一棵二叉树，返回其节点值的前序遍历。
 */

public class Num_66 {

    /*
     * @param root: A Tree
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
