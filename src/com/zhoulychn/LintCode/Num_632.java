package com.zhoulychn.LintCode;

import com.zhoulychn.BaseBean.StackAndQueue.SqQueue;
import com.zhoulychn.BaseBean.Tree.TreeNode;

public class Num_632 {

    /*
     * @param root: the root of tree
     * @return: the max node
     */
    public TreeNode maxNode(TreeNode root) {
        if (root == null) return null;
        SqQueue<TreeNode> queue = new SqQueue<TreeNode>();
        queue.enQueue(root);
        TreeNode result = root;
        while (queue.isNotEmpty()) {
            TreeNode node = queue.deQueue();
            if (node.val > result.val) result = node;
            if (node.left != null) queue.enQueue(node.left);
            if (node.right != null) queue.enQueue(node.right);
        }
        return result;
    }
}
