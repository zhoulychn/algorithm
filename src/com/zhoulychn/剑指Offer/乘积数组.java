package com.zhoulychn.剑指Offer;

/*

给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。

 */
public class 乘积数组 {
    public int[] multiply(int[] A) {
        int[] temp = new int[A.length];
        int v = 1;
        for (int i = 0; i < A.length; i++) {
            temp[i] = v;
            v *= A[i];
        }
        v = 1;
        for (int i = A.length - 1; i >= 0; i--) {
            temp[i] *= v;
            v *= A[i];
        }
        return temp;
    }
}
