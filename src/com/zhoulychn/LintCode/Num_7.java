package com.zhoulychn.LintCode;

import com.zhoulychn.BaseBean.Tree.TreeNode;
import org.junit.Test;

public class Num_7 {

    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        TreeNode[] queue = new TreeNode[1024];
        int rear = 0, front = 0;
        queue[rear++] = root;
        int start = 0, last = 0;
        boolean flag = true;
        while (true) {
            TreeNode node = queue[front++];
            if (node == null)
                continue;
            if (node.left != null || node.right != null) {
                flag = true;
            }
            queue[rear++] = root.left;
            queue[rear++] = root.right;

            if (front == last) {
                start = front;
                last = rear - 1;
                if (flag) {
                    flag = false;
                } else {
                    break;
                }
            }
        }
        for (int i = 0; i < start; i++) {
            result.append(queue[i] == null ? "#" : queue[i].val);
        }
        return result.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        return null;
    }

    @Test
    public void run() {

    }
}
