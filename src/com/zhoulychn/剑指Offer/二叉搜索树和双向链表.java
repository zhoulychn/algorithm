package com.zhoulychn.剑指Offer;

import com.zhoulychn.Tools;
import com.zhoulychn.common.tree.TreeNode;

public class 二叉搜索树和双向链表 {

    // 左右子树都是null的节点
    private TreeNode leftLast = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        if (pRootOfTree.left == null && pRootOfTree.right == null) {
            leftLast = pRootOfTree;
            return pRootOfTree;
        }
        TreeNode left = Convert(pRootOfTree.left);
        if (left != null) {

            // 左右子树都是null的节点，右边是父节点
            leftLast.right = pRootOfTree;
            pRootOfTree.left = leftLast;
        }
        leftLast = pRootOfTree;
        TreeNode right = Convert(pRootOfTree.right);
        if (right != null) {

            // 右边的左结点是父节点
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }

        // 左边为空就返回右边
        return left != null ? left : pRootOfTree;
    }

    public static void main(String[] args) {
        new 二叉搜索树和双向链表().Convert(Tools.buildTree(new Integer[]{8, 6, 10, 5, 7, 9, 11}));
    }
}
