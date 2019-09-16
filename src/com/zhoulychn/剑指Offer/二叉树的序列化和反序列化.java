package com.zhoulychn.剑指Offer;

import com.zhoulychn.Tools;
import com.zhoulychn.common.tree.TreeNode;

public class 二叉树的序列化和反序列化 {

    public int index = -1;

    private String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) return sb.append("#,").toString();

        sb.append(root.val).append(",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    private TreeNode Deserialize(String str) {

        // 节点值的位置
        index++;
        if (index >= str.length()) return null;

        // 使用逗号分隔
        String[] list = str.split(",");
        TreeNode node = null;

        // 如果节点值不是#号
        if (!list[index].equals("#")) {

            // 创建节点
            node = new TreeNode(Integer.parseInt(list[index]));

            // 左节点，右节点
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }
        return node;
    }

    public static void main(String[] args) {
        String serialize = new 二叉树的序列化和反序列化().Serialize(Tools.buildTree(new Integer[]{1, 2, 3, 4, 5, 6}));
        System.out.println(serialize);

        TreeNode deserialize = new 二叉树的序列化和反序列化().Deserialize("1,2,4,#,#,5,#,#,3,6,#,#,#,");
    }
}
