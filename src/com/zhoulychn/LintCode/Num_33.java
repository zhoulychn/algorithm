package com.zhoulychn.LintCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lewis on 2018/3/19
 */
public class Num_33 {

    private static int sum = 0;


    public static int solveNQueens(int n) {
        List<Integer> track = new ArrayList<>(n + 1);
        track.add(0);
        backTrack(track, n);
        return sum;
    }

    private static void backTrack(List<Integer> track, int n) {
        int size = track.size();

        if (size == n + 1) {
            sum++;
            track.remove(size - 1);
            return;
        }

        for (int j = 1; j <= n; j++) {
            if (isNotAttack(track, j)) {
                track.add(j);
                backTrack(track, n);
            }
        }
        track.remove(size - 1);
    }

    private static boolean isNotAttack(List<Integer> track, int index) {
        int size = track.size();
        if (size == 1) return true;
        for (int i = 1; i < size; i++) {
            if (index == track.get(i) || size - i == Math.abs(index - track.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int i = solveNQueens(14);
        System.out.println(i);
    }
}
