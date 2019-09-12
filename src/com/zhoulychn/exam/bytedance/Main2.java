package com.zhoulychn.exam.bytedance;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main2 {

    public int[][] run(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            LinkedList<Integer> temp = new LinkedList<>();

            // 不为0的数加入列表
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) temp.add(arr[i][j]);
            }
            for (int j = 0; j < arr[i].length; j++) {

                // 列表为空，直接加0
                if (temp.size() == 0) {
                    arr[i][j] = 0;
                    continue;
                }

                // 取数
                Integer v = temp.pop();

                // 赋值
                arr[i][j] = v;

                // 后面一个可以合并就取出
                if (temp.size() > 0 && temp.getFirst().equals(v)) {
                    temp.pop();
                    arr[i][j] *= 2;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] run = new Main2().run(new int[][]{{0, 0, 2, 4}, {0, 2, 2,}, {0, 4, 2, 2}, {8, 8, 2, 2}});
    }
}
