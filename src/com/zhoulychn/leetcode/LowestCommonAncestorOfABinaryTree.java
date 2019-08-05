package com.zhoulychn.leetcode;

import com.zhoulychn.Tools;
import com.zhoulychn.common.list.ListNode;
import com.zhoulychn.common.tree.TreeNode;

import java.util.*;

/*

给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]

示例 1:

输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出: 3
解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
示例 2:

输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
输出: 5
解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。

说明:

所有节点的值都是唯一的。
p、q 为不同节点且均存在于给定的二叉树中。

 */
public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<Integer, TreeNode> map = new HashMap<>();
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        while (queue.size() != 0 && (map.get(p.val) == null || map.get(q.val) == null)) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                map.put(node.left.val, node);
                queue.addLast(node.left);
            }
            if (node.right != null) {
                map.put(node.right.val, node);
                queue.addLast(node.right);
            }
        }
        LinkedList<TreeNode> s1 = new LinkedList<>();
        LinkedList<TreeNode> s2 = new LinkedList<>();
        s1.addFirst(p);
        s2.addFirst(q);
        while (map.get(p.val) != null) {
            TreeNode node = map.get(p.val);
            s1.addFirst(node);
            p = node;
        }
        while (map.get(q.val) != null) {
            TreeNode node = map.get(q.val);
            s2.addFirst(node);
            q = node;
        }
        int i;
        for (i = 0; i < s1.size() && i < s2.size(); i++) {
            if (s1.get(i).val != s2.get(i).val) return s1.get(i - 1);
        }
        return s1.get(i - 1);
    }

    public static void main(String[] args) {
        new LowestCommonAncestorOfABinaryTree().lowestCommonAncestor(
                Tools.build(new Integer[]{1, 2}, 0),
                new TreeNode(5), new TreeNode(1));
    }
}
