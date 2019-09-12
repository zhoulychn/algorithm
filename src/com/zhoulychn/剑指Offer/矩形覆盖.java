package com.zhoulychn.剑指Offer;

public class 矩形覆盖 {

    public int RectCover(int target) {
        if (target < 1) return 0;
        if (target == 1) return 1;
        if (target == 2) return 2;
        int v1 = 1, v2 = 2;
        for (int i = 3; i <= target; i++) {
            int temp = v2;
            v2 = v1 + v2;
            v1 = temp;
        }
        return v2;
    }
}
