package com.zhoulychn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class 满意度 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            String[] s = sc.nextLine().split(" ");
            a[i] = Integer.parseInt(s[0]);
            b[i] = Integer.parseInt(s[1]);
        }

        List<List<Integer>> res = new LinkedList<>();

        res.add(new LinkedList<>());

        for (int i = 0; i < n; i++) {

            int size = res.size();

            for (int j = 0; j < size; j++) {

                List<Integer> cur = res.get(j);
                for (int k = 0; k <= cur.size(); k++) {
                    List<Integer> temp = new LinkedList<>(cur);
                    temp.add(k, i);
                    res.add(temp);
                }
            }

            for (int j = 0; j < size; j++) {
                res.remove(0);
            }
        }

        int min = Integer.MAX_VALUE;

        for (List<Integer> list : res) {

            int sum = 0;
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    sum += b[list.get(i)] * (list.size() - i + 1);
                    continue;
                } else if (i == list.size() - 1) {
                    sum += a[list.get(i)] * (i + 1);
                    continue;
                } else {
                    sum += b[list.get(i)] * (list.size() - i + 1);
                    sum += a[list.get(i)] * (i + 1);
                }
            }

            min = Math.min(sum, min);
        }
        System.out.println(min);
    }


}
