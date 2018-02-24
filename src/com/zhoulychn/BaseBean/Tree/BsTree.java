package com.zhoulychn.BaseBean.Tree;

public class BsTree<Key extends Comparable<Key>, Value> {

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int N;

        public Node(Key key, Value val, int n) {
            this.key = key;
            this.val = val;
            N = n;
        }
    }

    private Node root;

    public int size() {
        return size(root);
    }

    private int size(Node node) {
        return node == null ? 0 : node.N;
    }
}
