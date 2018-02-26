package com.zhoulychn.Utils;

import com.zhoulychn.BaseBean.Tree.TreeNode;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.Scanner;

public class BiTreeUtils {

    public static void preOrder(TreeNode tree) {
        if (tree != null) {
            visit(tree);
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    public static void inOrder(TreeNode tree) {
        if (tree != null) {
            inOrder(tree.left);
            visit(tree);
            inOrder(tree.right);
        }
    }

    public static void postOrder(TreeNode tree) {
        if (tree != null) {
            postOrder(tree.left);
            postOrder(tree.right);
            visit(tree);
        }
    }

    public static void visit(TreeNode tree) {
        System.out.println(tree.val);
    }

    public static TreeNode createByScan(TreeNode tree) {
        Scanner input = new Scanner(System.in);
        int i = input.nextInt();
        if (0 == i) return null;
        tree.val = i;
        tree.left = new TreeNode();
        tree.right = new TreeNode();
        tree.left = createByScan(tree.left);
        tree.right = createByScan(tree.right);
        return tree;
    }

    public static TreeNode createByFile(TreeNode tree, String path) throws Exception {
        File file = new File(path);
        Reader reader = new FileReader(file);
        char[] buf = new char[2014];
        System.out.println(reader.read(buf));
        System.out.println(buf);
        return tree;
    }
}