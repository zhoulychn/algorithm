package com.zhoulychn;


import com.zhoulychn.BaseBean.Graph.ALGraph;
import com.zhoulychn.BaseBean.StackAndQueue.Queue;
import com.zhoulychn.Utils.GraphUtils;
import com.zhoulychn.Utils.QueueUtils;

public class Application {

    public static void main(String[] args) throws Exception {
        ALGraph graph = new ALGraph();
        GraphUtils.init(graph);
//        GraphUtils.depthFirstSearch(graph, 1);
        GraphUtils.breadthFirstSearch(graph, 1);

    }
}
