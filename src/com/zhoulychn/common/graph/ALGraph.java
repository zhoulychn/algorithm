package com.zhoulychn.common.graph;

public class ALGraph {

    private VNode[] vertices;

    private int vexNum, arcNum;

    public VNode[] getVertices() {
        return vertices;
    }

    public void setVertices(VNode[] vertices) {
        this.vertices = vertices;
    }

    public int getVexNum() {
        return vexNum;
    }

    public void setVexNum(int vexNum) {
        this.vexNum = vexNum;
    }

    public int getArcNum() {
        return arcNum;
    }

    public void setArcNum(int arcNum) {
        this.arcNum = arcNum;
    }
}
