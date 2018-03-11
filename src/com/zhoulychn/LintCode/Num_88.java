package com.zhoulychn.LintCode;

import com.zhoulychn.BaseBean.Tree.TreeNode;
import com.zhoulychn.Utils.TreeUtils;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lewis on 2018/3/11
 */
public class Num_88 {

    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {

        if (root == null || root == A || root == B) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);

        if (left != null && right != null) {
            return root;
        }
        if (left != null)
            return left;

        if (right != null)
            return right;

        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        TreeUtils.createByScan(root);
        TreeNode node = lowestCommonAncestor(root, root.right.right, root.right.right.right.right);
    }
}
