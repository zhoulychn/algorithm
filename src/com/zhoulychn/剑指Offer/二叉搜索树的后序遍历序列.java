package com.zhoulychn.剑指Offer;

public class 二叉搜索树的后序遍历序列 {

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) return false;
        return VerifySquenceOfBST(sequence, 0, sequence.length - 1);
    }

    public boolean VerifySquenceOfBST(int[] sequence, int lo, int hi) {
        if (lo >= hi) return true;
        int i = lo;
        while (i < hi && sequence[i] < sequence[hi]) i++;
        for (int j = i; j < hi; j++) {
            if (sequence[j] < sequence[hi]) return false;
        }
        return VerifySquenceOfBST(sequence, lo, i - 1) && VerifySquenceOfBST(sequence, i, hi - 1);
    }

    public static void main(String[] args) {
        boolean b = new 二叉搜索树的后序遍历序列().VerifySquenceOfBST(new int[]{4, 6, 12, 8, 16, 14, 10});
    }
}
