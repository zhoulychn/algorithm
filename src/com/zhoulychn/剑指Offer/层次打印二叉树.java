package com.zhoulychn.剑指Offer;

import com.zhoulychn.common.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class 层次打印二叉树 {

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) return result;
        ArrayList<Integer> temp = new ArrayList<>();
        result.add(temp);
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode last = pRoot;
        queue.addLast(pRoot);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            temp.add(node.val);
            if (node.left != null) queue.addLast(node.left);
            if (node.right != null) queue.addLast(node.right);
            if (node == last && !queue.isEmpty()) {
                last = queue.peekLast();
                temp = new ArrayList<>();
                result.add(temp);
            }
        }
        return result;
    }
}
