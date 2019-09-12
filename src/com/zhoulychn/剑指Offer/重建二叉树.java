package com.zhoulychn.剑指Offer;

import com.zhoulychn.common.tree.TreeNode;

public class 重建二叉树 {

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return build(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public TreeNode build(int[] pre, int i, int j, int[] in, int x, int y) {

        // i>j推出
        if (i > j) return null;
        TreeNode node = new TreeNode(pre[i]);

        // 在中序遍历里面找到根节点，拆分为左右两段
        for (int k = x; k <= y; k++) {
            if (pre[i] == in[k]) {

                // 中序 k-1 到 x的长度等于 j 到i-1 的长度，求出 k-1-x = j - (i-1) j = k-x+1
                node.left = build(pre, i + 1, k - x + i, in, x, k - 1);

                // 上一次的j +1
                node.right = build(pre, k - x + i + 1, j, in, k + 1, y);
            }
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new 重建二叉树().reConstructBinaryTree(new int[]{1, 2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6});
    }
}
