package com.zhoulychn.LintCode;

import org.junit.Test;

public class Num_6 {

    /**
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        int[] result = new int[A.length + B.length];
        int m = 0, n = 0;
        int i = 0;
        while (m != A.length && n != B.length) {
            if (A[m] <= B[n]) {
                result[i++] = A[m++];
            } else {
                result[i++] = B[n++];
            }
        }

        //result设置完,i应该等于length，最后一个下标+1
        if (m == A.length) {
            while (i != result.length)
                result[i++] = B[n++];
        } else {
            while (i != result.length)
                result[i++] = A[m++];
        }
        return result;
    }

    @Test
    public void run() {
        int[] A = {1};
        int[] B = {1};
        System.out.println(mergeSortedArray(A, B));
    }
}
