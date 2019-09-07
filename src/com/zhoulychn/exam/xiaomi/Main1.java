package com.zhoulychn.exam.xiaomi;

import com.zhoulychn.common.tree.TreeNode;

import java.util.Stack;

public class Main1 {

    private static TreeNode build(String str) {
        if ("".equals(str)) return null;

        StringBuilder sb = new StringBuilder(str);
        TreeNode treeNode = new TreeNode(sb.charAt(0) - '0');
        sb.deleteCharAt(0);

        if ("".equals(sb.toString())) return treeNode;
        sb.deleteCharAt(0);
        sb.deleteCharAt(sb.length() - 1);

        Stack<Character> stack = new Stack<>();
        int index = 0;
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (stack.size() == 0 && c == ',') {
                index = i;
                break;
            }
            if (c == ')') stack.pop();
            if (c == '(') stack.push('(');
        }

        String str1 = sb.toString().substring(0, index);
        String str2 = sb.toString().substring(index + 1, sb.length());

        treeNode.left = build(str1);
        treeNode.right = build(str2);
        return treeNode;
    }


//    private void Main() {
//        //公鸡的上线
//        for (int x = 1; x < 20; x++) {
//            //母鸡的上线
//            for (int y = 1; y < 33; y++) {
//                //剩余小鸡
//                int z = 100 - x - y;
//
//                if ((z % 3 == 0) && (x * 5 + y * 3 + z / 3 == 100)) {
//                    Console.WriteLine("公鸡:{0}只，母鸡:{1}只,小鸡:{2}只", x, y, z);
//                }
//            }
//        }
//        Console.Read();
//    }

    public static void main(String[] args) {
        TreeNode build = build("1(2(3,4(,5)),6(7,))");
        System.out.println(build);
    }


    public static int backPackII(int m, int[] A, int[] V) {
        //最优解数据保存，二维数组保存每一次加入物品后各个重量的局部最优解，清晰理解。
        //此处也可以跟上个问题一样，用一维数组保存最后一次加入物品后的最优解即可。
        int s = A.length;
        //s为物品数量，m为背包重量，下标从1开始。
        int wt[][] = new int[s + 1][m + 1];
        //遍历每个物品
        for (int i = 1; i <= s; i++) {
            //获取当前物品重量和价值
            int weight = A[i - 1], value = V[i - 1];
            for (int j = 1; j <= m; j++) {
                //可以装下当前物品，则判断价值是否最优
                if (j >= weight)
                    wt[i][j] = Math.max(wt[i - 1][j], wt[i - 1][j - weight] + value);
                    //不能装下则直接为上次结果
                else
                    wt[i][j] = wt[i - 1][j];
            }
        }
        return wt[s][m];
    }

}
