package com.zhoulychn.exam.xiaomi;

import com.zhoulychn.common.tree.TreeNode;

import java.util.Stack;

public class Main1 {

    private static TreeNode Deserialize(String str) {
        if ("#".equals(str)) return null;

        StringBuilder sb = new StringBuilder(str);

        // 取出根节点
        TreeNode treeNode = new TreeNode(sb.charAt(0) - '0');
        sb.deleteCharAt(0);

        // 如果没有左右子树，返回
        if ("".equals(sb.toString())) return treeNode;

        // 删除左右的括号
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length() - 1);

        Stack<Character> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);

            // 如果栈为0，且当前字符为逗号，是区分点
            if (stack.size() == 0 && c == ',') {
                index = i;
                break;
            }
            if (c == ')') stack.pop();
            if (c == '(') stack.push('(');
        }

        String str1 = sb.toString().substring(0, index);
        String str2 = sb.toString().substring(index + 1, sb.length());

        treeNode.left = Deserialize(str1);
        treeNode.right = Deserialize(str2);
        return treeNode;
    }

    private static String Serialize(TreeNode root) {
        if (root == null) return "#";
        return root.val + "(" + Serialize(root.left) + "," + Serialize(root.right) + ")";
    }


    public static void main(String[] args) {
        TreeNode build = Deserialize("1(2(3,4(,5)),6(7,))");
        System.out.println(build);
    }


}
