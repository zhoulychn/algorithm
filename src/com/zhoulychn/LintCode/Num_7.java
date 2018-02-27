package com.zhoulychn.LintCode;

import com.zhoulychn.BaseBean.StackAndQueue.SqQueue;
import com.zhoulychn.BaseBean.Tree.TreeNode;
import com.zhoulychn.Utils.TreeUtils;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class Num_7 {

    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public static String serialize(TreeNode root) {
        if (root == null) return "{}";
        StringBuilder result = new StringBuilder();
        result.append("{" + root.val + ',');
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            boolean flag = false;
            int size = queue.size();
            TreeNode[] list = new TreeNode[size];
            for (int i = 0; i < size; i++) {
                list[i] = queue.poll();
                if (list[i].left != null || list[i].right != null) flag = true;
            }
            if (flag) {
                for (int i = 0; i < list.length; i++) {
                    TreeNode node = list[i];
                    if (node.left != null) {
                        result.append(node.left.val + ",");
                        queue.offer(node.left);
                    } else {
                        result.append("#,");
                    }
                    if (node.right != null) {
                        result.append(node.right.val + ",");
                        queue.offer(node.right);
                    } else {
                        result.append("#,");
                    }
                }
            }
        }
        return result.deleteCharAt(result.length() - 1).append("}").toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        if (data.equals("#")) {
            return null;
        }
        String[] tree = data.split(",");
        Queue<String> queue = new LinkedList<>();
        for (String node : tree) {
            queue.offer(node);
        }
        int rootval = Integer.parseInt(queue.poll());
        TreeNode root = new TreeNode(rootval);
        Queue<TreeNode> resultQueue = new LinkedList<>();
        resultQueue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode currNode = resultQueue.poll();
            String left = queue.poll();
            if (!left.equals("#")) {
                currNode.left = new TreeNode(Integer.parseInt(left));
                resultQueue.offer(currNode.left);
            }
            String right = queue.poll();
            if (!right.equals("#")) {
                currNode.right = new TreeNode(Integer.parseInt(right));
                resultQueue.offer(currNode.right);
            }
        }
        return root;
    }

}
