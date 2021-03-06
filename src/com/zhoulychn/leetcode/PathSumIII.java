package com.zhoulychn.leetcode;


import com.zhoulychn.Tools;
import com.zhoulychn.common.tree.TreeNode;

/*
给定一个二叉树，它的每个结点都存放着一个整数值。

找出路径和等于给定数值的路径总数。

路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。

二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。

示例：

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

返回 3。和等于 8 的路径有:

1.  5 -> 3
2.  5 -> 2 -> 1
3.  -3 -> 11
 */
public class PathSumIII {

    public int pathSum(TreeNode root, int sum) {

        if (root == null) return 0;

        // 搜索以当前节点为根节点的路径+左子树+右子树
        return search(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public int search(TreeNode root, int sum) {

        // 路径结束没找到返回0
        if (root == null) return 0;

        // 当前路径可能已经符合，但是不保证向下找还可以符合，所以结果要+1
        sum -= root.val;

        // 当前是否完成+左子树查找+右子树查找
        return (sum == 0 ? 1 : 0) + search(root.left, sum) + search(root.right, sum);
    }

    public static void main(String[] args) {
        TreeNode tree = Tools.buildTree(new Integer[]{1, null, 2, null, 3, null, 4, null, 5});
        int i = new PathSumIII().pathSum(tree, 3);
        System.out.println(i);
    }
}
