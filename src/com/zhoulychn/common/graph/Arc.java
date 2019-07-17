package com.zhoulychn.common.graph;

public class Arc {

    private int vex;

    private Arc next;

    private int weigh;

    public Arc(int vex, Arc next) {
        this.vex = vex;
        this.next = next;
    }

    public int getVex() {
        return vex;
    }

    public void setVex(int vex) {
        this.vex = vex;
    }

    public Arc getNext() {
        return next;
    }

    public void setNext(Arc next) {
        this.next = next;
    }

    public int getWeigh() {
        return weigh;
    }

    public void setWeigh(int weigh) {
        this.weigh = weigh;
    }
}
