package com.zhoulychn.Utils;


import com.zhoulychn.BaseBean.Tree.BiTree;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.Scanner;

public class BiTreeUtils {

    public static void preOrder(BiTree tree) {
        if (tree != null) {
            visit(tree);
            preOrder(tree.getLeft());
            preOrder(tree.getRight());
        }
    }

    public static void inOrder(BiTree tree) {
        if (tree != null) {
            inOrder(tree.getLeft());
            visit(tree);
            inOrder(tree.getRight());
        }
    }

    public static void postOrder(BiTree tree) {
        if (tree != null) {
            postOrder(tree.getLeft());
            postOrder(tree.getRight());
            visit(tree);
        }
    }

    public static void visit(BiTree tree) {
        System.out.println(tree.getValue());
    }

    public static BiTree createByScan(BiTree tree) {
        Scanner input = new Scanner(System.in);
        int i = input.nextInt();
        if (0 == i) return null;
        tree.setValue(i);
        tree.setLeft(new BiTree());
        tree.setRight(new BiTree());
        tree.setLeft(createByScan(tree.getLeft()));
        tree.setRight(createByScan(tree.getRight()));
        return tree;
    }

    public static BiTree createByFile(BiTree tree, String path) throws Exception {
        File file = new File(path);
        Reader reader = new FileReader(file);
        char[] buf = new char[2014];
        System.out.println(reader.read(buf));
        System.out.println(buf);
        return tree;
    }
}