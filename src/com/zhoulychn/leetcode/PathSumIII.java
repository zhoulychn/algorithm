package com.zhoulychn.leetcode;


import java.util.ArrayDeque;
import java.util.Queue;

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
        int count = 0;

        if (root == null) return count;

        //层次遍历，每个节点当作根查找
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            count += search(node, sum);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return count;
    }

    public int search(TreeNode root, int sum) {

        //路径结束没找到返回0
        if (root == null) return 0;

        //当前路径可能已经符合，但是不保证向下找还可以符合，所以结果要+1
        int temp = 0;
        if (root.val == sum) temp++;

        //当前是否完成+左子树查找+右子树查找
        return temp + search(root.left, sum - root.val) + search(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        TreeNode tree = Tools.build(new Integer[]{1, -2, -3, 1, 3, -2, null, -1}, 0);
        int i = new PathSumIII().pathSum(tree, -1);
        System.out.println(i);
    }
}
