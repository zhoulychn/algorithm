package com.zhoulychn.LintCode;

import com.zhoulychn.BaseBean.Tree.TreeNode;
import com.zhoulychn.Utils.TreeUtils;
import org.junit.Test;
import sun.reflect.generics.tree.Tree;

/**
 * Created by Lewis on 2018/3/10
 */
public class Num_94 {

    private static int max = Integer.MIN_VALUE;


    private static int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }

    private static int helper(TreeNode root) {

        int left = (root.left == null ? 0 : helper(root.left));

        int right = (root.right == null ? 0 : helper(root.right));

        int sum = left + right + root.val;

        max = (sum > max ? sum : max);

        int val = root.val + (left > right ? left : right);

        return val > 0 ? val : 0;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        TreeUtils.createByScan(root);

        int i = maxPathSum(root);
    }
}
