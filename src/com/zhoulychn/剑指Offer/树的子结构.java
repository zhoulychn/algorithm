package com.zhoulychn.剑指Offer;


import com.zhoulychn.Tools;
import com.zhoulychn.common.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class 树的子结构 {

    private List<TreeNode> list = new LinkedList<>();

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return false;
        search(root1, root2);
        boolean flag = false;
        for (TreeNode treeNode : list) {
            flag |= judge(treeNode, root2);
        }
        return flag;
    }

    // 查找相同的节点，这些都是需要比较的
    private void search(TreeNode root1, TreeNode root2) {
        if (root1 == null) return;
        if (root1.val == root2.val) list.add(root1);
        search(root1.left, root2);
        search(root1.right, root2);
    }

    // 递归判断是否相同，当子树的左右节点为空不需要比较
    private boolean judge(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;
        boolean flag = true;

        if (root2.left != null) flag = judge(root1.left, root2.left);
        if (root2.right != null) flag &= judge(root1.right, root2.right);
        return flag;
    }

    public static void main(String[] args) {
        boolean b = new 树的子结构().HasSubtree(Tools.buildTree(new Integer[]{8, 8, 7, 9, 2, null, null, null, null, 4, 7}), Tools.buildTree(new Integer[]{8, 9, 2}));
    }

}
