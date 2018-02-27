package com.zhoulychn.BaseBean.Tree;

public class TreeNode {

    public Integer val;

    public TreeNode left;

    public TreeNode right;


    public TreeNode() {

    }

    public TreeNode(int value) {
        this.val = value;
        left = null;
        right = null;
    }
}