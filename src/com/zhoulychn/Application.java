package com.zhoulychn;


import com.zhoulychn.BaseBean.Tree.TreeNode;
import com.zhoulychn.LintCode.Num_7;
import com.zhoulychn.Utils.TreeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Application {

    public enum Calc {

        ADD, MINUS, MULTIPLY, DIVIDE;

        public static int execute(int a, int b, Calc calc) {
            switch (calc) {
                case ADD:
                    return a + b;
                case MINUS:
                    return a - b;
                case DIVIDE:
                    return a / b;
                case MULTIPLY:
                    return a * b;
                default:
                    return Integer.MIN_VALUE;
            }
        }
    }
}
