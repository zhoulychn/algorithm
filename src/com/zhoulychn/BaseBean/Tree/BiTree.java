package com.zhoulychn.BaseBean.Tree;

public class BiTree {

    private Integer value;

    private BiTree left;

    private BiTree right;

    public BiTree() {

    }

    public BiTree(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public BiTree getLeft() {
        return left;
    }

    public void setLeft(BiTree left) {
        this.left = left;
    }

    public BiTree getRight() {
        return right;
    }

    public void setRight(BiTree right) {
        this.right = right;
    }
}
