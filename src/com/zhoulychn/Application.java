package com.zhoulychn;


import com.zhoulychn.BaseBean.Graph.ALGraph;
import com.zhoulychn.BaseBean.StackAndQueue.Queue;
import com.zhoulychn.LintCode.Num_5;
import com.zhoulychn.Utils.GraphUtils;
import com.zhoulychn.Utils.QueueUtils;

import java.util.ArrayList;
import java.util.Stack;

public class Application {

    public static void main(String[] args) throws Exception {
        int[] nums = {1,2,3,4,5,6,8,9,10,7};
        int k = 10;
        Num_5 demo = new Num_5();
        int i = demo.kthLargestElement(k, nums);
        System.out.println(i);
    }
}
