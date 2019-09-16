package com.zhoulychn.剑指Offer;

import com.zhoulychn.common.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/*

请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。

 */
public class 之字形打印 {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) return result;
        ArrayList<Integer> temp = new ArrayList<>();
        result.add(temp);
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode last = pRoot;
        queue.addLast(pRoot);
        boolean flag = true;
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            if (flag) temp.add(node.val);
            else temp.add(0, node.val);
            if (node.left != null) queue.addLast(node.left);
            if (node.right != null) queue.addLast(node.right);
            if (node == last && !queue.isEmpty()) {
                last = queue.peekLast();
                temp = new ArrayList<>();
                result.add(temp);
                flag = !flag;
            }
        }
        return result;
    }
}
