package com.zhoulychn.leetcode;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*

给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 

示例 1:

输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
输出: 6
解释: 节点 2 和节点 8 的最近公共祖先是 6。
示例 2:

输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
输出: 2
解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 

说明:

所有节点的值都是唯一的。
p、q 为不同节点且均存在于给定的二叉搜索树中。

 */
public class LowestCommonAncestorOfABinarySearchTree {


    // 找到根结点到两个结点之间的路径，最后一个不相同的结点为最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list = new ArrayList<>();
        TreeNode node = root;
        list.add(node);
        while (node.val != p.val) {
            if (p.val < node.val) node = node.left;
            else node = node.right;
            list.add(node);
        }
        node = root;
        int i = 0;
        while (node.val != q.val) {
            if (q.val < node.val) node = node.left;
            else node = node.right;
            if (i >= list.size() - 1 || node != list.get(i + 1)) return list.get(i);
            i++;
        }
        return list.get(i);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new LowestCommonAncestorOfABinarySearchTree()
                .lowestCommonAncestor(Tools.build(new Integer[]{5, 3, 6, 1, 4, null, null, null, 2}, 0), new TreeNode(4), new TreeNode(2));
        System.out.println(treeNode.val);
    }
}
