package com.zhoulychn.LintCode;

import com.zhoulychn.BaseBean.Tree.TreeNode;

/**
 * Created by Lewis on 2018/3/3
 * <p>
 * 给定一个二叉树,确定它是高度平衡的。对于这个问题,一棵高度平衡的二叉树的定义是：一棵二叉树中每个节点的两个子树的深度相差不会超过1。
 */
public class Num_93 {


    private boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        if (!isBalanced(root.left) || !isBalanced(root.right))
            return false;

        int left = getDepth(root.left);
        int right = getDepth(root.right);

        return Math.abs(left - right) <= 1;
    }

    private int getDepth(TreeNode root) {
        if (root == null)
            return 0;

        int left = getDepth(root.left);
        int right = getDepth(root.right);

        return Math.max(left, right) + 1;
    }
}
