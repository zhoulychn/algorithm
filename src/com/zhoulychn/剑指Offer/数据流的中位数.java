package com.zhoulychn.剑指Offer;

import java.util.ArrayList;

public class 数据流的中位数 {

    public ArrayList<Integer> list = new ArrayList<>();

    public void Insert(Integer num) {

        if (list.size() == 0) list.add(num);
        if (list.size() != 0 && num > list.get(list.size() - 1)) {
            list.add(num);
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (num < list.get(i)) {
                list.add(i, num);
                return;
            }
        }
    }

    public Double GetMedian() {
        if (list.size() % 2 == 1) return Double.valueOf(list.get(list.size() / 2));
        Double v1 = Double.valueOf(list.get(list.size() / 2 - 1));
        Double v2 = Double.valueOf(list.get(list.size() / 2));
        return (v1 + v2) / 2;
    }
}
