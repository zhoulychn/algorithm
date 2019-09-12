package com.zhoulychn.剑指Offer;

import com.zhoulychn.common.tree.TreeNode;

import java.util.ArrayList;

/*

输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)

 */
public class 二叉树中和为某一值的路径 {

    private ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) return listAll;
        list.add(root.val);
        target -= root.val;

        // 和为值，且为叶子节点保存数据
        if (target == 0 && root.left == null && root.right == null) listAll.add(new ArrayList<>(list));

        // 找到左右子树也为target
        FindPath(root.left, target);
        FindPath(root.right, target);

        // 移除最后一个
        list.remove(list.size() - 1);
        return listAll;
    }
}
