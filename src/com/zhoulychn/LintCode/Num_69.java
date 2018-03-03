package com.zhoulychn.LintCode;

import com.zhoulychn.BaseBean.Tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lewis on 2018/3/2
 * <p>
 * 给出一棵二叉树，返回其节点值的层次遍历（逐层从左往右访问）
 */
public class Num_69 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        deque.offer(root);
        while (!deque.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = deque.size();

            //不要用deque的size方法，循环过程中会不断变化
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                list.add(node.val);
                if (node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);
            }
            result.add(list);
        }
        return result;
    }
}
