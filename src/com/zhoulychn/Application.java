package com.zhoulychn;


import com.zhoulychn.LintCode.Num_5;

public class Application {

    public static void main(String[] args) throws Exception {
        int[] nums = {1,2,3,4,5,6,8,9,10,7};
        int k = 10;
        Num_5 demo = new Num_5();
        int i = demo.kthLargestElement(k, nums);
        System.out.println(i);
    }
}
