package com.zhoulychn.common.utils;

import com.zhoulychn.common.graph.ALGraph;
import com.zhoulychn.common.graph.Arc;
import com.zhoulychn.common.graph.VNode;
import com.zhoulychn.common.stack.SqQueue;


public class GraphUtils {

    private static boolean[] mark = new boolean[1024];

    public static void init(ALGraph graph) {
        graph.setVexNum(5);
        graph.setArcNum(7);
        graph.setVertices(new VNode[6]);
        for (int i = 1; i < 6; i++) {
            graph.getVertices()[i] = new VNode(i);
        }
        linkMutual(graph, 1, 2);
        linkMutual(graph, 1, 5);
        linkMutual(graph, 2, 5);
        linkMutual(graph, 2, 3);
        linkMutual(graph, 2, 4);
        linkMutual(graph, 3, 4);
        linkMutual(graph, 5, 4);
    }

    public static void linkMutual(ALGraph graph, int m, int n) {
        link(graph, m, n);
        link(graph, n, m);
    }


    public static void link(ALGraph graph, int m, int n) {
        VNode node = graph.getVertices()[m];
        Arc arc = node.getFirst();
        if (arc == null) {
            node.setFirst(new Arc(n, null));
        } else {
            while (arc.getNext() != null)
                arc = arc.getNext();
            arc.setNext(new Arc(n, null));
        }
    }

    public static void depthFirstSearch(ALGraph graph, int v) {
        System.out.println(v);
        mark[v] = true;
        VNode node = graph.getVertices()[v];
        Arc arc = node.getFirst();
        while (arc != null) {
            int value = arc.getVex();
            if (!mark[value])
                depthFirstSearch(graph, value);
            else
                arc = arc.getNext();
        }
    }

    public static void breadthFirstSearch(ALGraph graph, int v) {
        SqQueue<Integer> queue = new SqQueue<Integer>(64);
        queue.enQueue(v);
        System.out.println(v);
        mark[v] = true;
        while (!queue.isEmpty()) {
            int vex = queue.deQueue();
            VNode node = graph.getVertices()[vex];
            Arc arc = node.getFirst();
            while (arc != null) {
                int k = arc.getVex();
                if (!mark[k]) {
                    mark[k] = true;
                    System.out.println(k);
                    queue.enQueue(k);
                }
                arc = arc.getNext();
            }
        }
    }
}
