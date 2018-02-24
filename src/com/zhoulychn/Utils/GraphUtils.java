package com.zhoulychn.Utils;

import com.zhoulychn.BaseBean.Graph.ALGraph;
import com.zhoulychn.BaseBean.Graph.Arc;
import com.zhoulychn.BaseBean.Graph.VNode;
import com.zhoulychn.BaseBean.StackAndQueue.Queue;


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
        Queue queue = new Queue(64);
        QueueUtils.enQueue(queue, v);
        System.out.println(v);
        mark[v] = true;
        while (!QueueUtils.isEmpty(queue)) {
            int vex = QueueUtils.deQueue(queue);
            VNode node = graph.getVertices()[vex];
            Arc arc = node.getFirst();
            while (arc != null) {
                int k = arc.getVex();
                if (!mark[k]) {
                    mark[k] = true;
                    System.out.println(k);
                    QueueUtils.enQueue(queue, k);
                }
                arc = arc.getNext();
            }
        }
    }
}
