package com.zhoulychn.lintCode;

import com.zhoulychn.baseBean.Tree.TreeNode;

/**
 * Created by Lewis on 2018/3/3
 * <p>
 * 给定一棵二叉查找树和一个新的树节点，将节点插入到树中。
 * <p>
 * 你需要保证该树仍然是一棵二叉查找树。
 */

public class Num_85 {

    /*
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null) return node;
        if (node == null) return root;
        TreeNode q = root, p = null;
        if (node.val > q.val)
            p = q.right;
        if (node.val < q.val)
            p = q.left;
        while (p != null) {
            if (node.val > p.val) {
                q = p;
                p = p.right;
            } else {
                q = p;
                p = p.left;
            }
        }
        if (node.val > q.val)
            q.right = node;
        else
            q.left = node;
        return root;
    }
}
