package com.zhoulychn.leetcode;

import com.zhoulychn.common.tree.TreeNode;

/*

给定一个二叉树，原地将它展开为链表。

例如，给定二叉树

    1
   / \
  2   5
 / \   \
3   4   6
将其展开为：

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6

 */
public class FlattenBinaryTreeToLinkedList {

    // 平铺操作对每一颗子树都相同，所以递归
    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode left = root.left;
        TreeNode right = root.right;
        flatten(left);
        flatten(right);

        // 左子树为null，root的右子树直接连接右子树
        if (root.left == null) {
            root.right = right;
            return;
        }

        // 找到左子树的尾巴，连接到右子树
        TreeNode node = left;
        while (node.right != null) {
            node = node.right;
        }
        node.right = right;


        // 平铺后，右子树为原左子树，左子树设置为null
        root.right = left;
        root.left = null;
    }
}
