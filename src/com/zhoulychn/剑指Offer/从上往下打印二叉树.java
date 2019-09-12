package com.zhoulychn.剑指Offer;

import com.zhoulychn.common.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/*

从上往下打印出二叉树的每个节点，同层节点从左至右打印。

 */
public class 从上往下打印二叉树 {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.addLast(root);
        while (!list.isEmpty()) {
            TreeNode node = list.pop();
            result.add(node.val);
            if (node.left != null) list.addLast(node.left);
            if (node.right != null) list.addLast(node.right);
        }
        return result;
    }
}
