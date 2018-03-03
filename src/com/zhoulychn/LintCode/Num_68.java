package com.zhoulychn.LintCode;

import com.zhoulychn.BaseBean.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Lewis on 2018/3/2
 *
 * 给出一棵二叉树，返回其节点值的后序遍历。
 */

public class Num_68 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> temp = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            temp.push(node);
            if (node.left != null) stack.push(node.left);
            if (node.right != null) stack.push(node.right);
        }
        while (!temp.isEmpty()) result.add(temp.pop().val);
        return result;
    }

}
