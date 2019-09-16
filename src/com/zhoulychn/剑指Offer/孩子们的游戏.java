package com.zhoulychn.剑指Offer;

import java.util.LinkedList;

public class 孩子们的游戏 {

    public int LastRemaining_Solution(int n, int m) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        for (int i = 0; list.size() > 1; ) {
            // 0+m-1为删除的元素，下一个0也是这个位置
            i = (i + m - 1) % list.size();
            list.remove(i);
        }
        return list.size() > 0 ? list.get(0) : -1;
    }
}
