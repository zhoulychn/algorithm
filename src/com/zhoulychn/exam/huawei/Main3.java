package com.zhoulychn.exam.huawei;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        while (in.hasNextLine()) {
            list.add(in.nextLine());
        }
    }

    private static int calc(ArrayList<String> list) {
        LinkedList<Character> res = new LinkedList<>();

        for (String s : list) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '[' || s.charAt(i) == ']' || s.charAt(i) == '{'
                        || s.charAt(i) == '}' || s.charAt(i) == '"')
                    res.addFirst(s.charAt(i));
            }
        }
        while (res.size() != 0) {
            Character c1 = res.pollFirst();
            if (c1=='}') return 2;
            if (c1==']') return 1;

            if (res.size() == 0 && (c1 == '[' || c1 == ']')) {
                return 1;
            }
            if (res.size() == 0 && (c1 == '{' || c1 == '}')) {
                return 2;
            }
            if (res.size() == 0 && c1 == '"') {
                return 3;
            }
            if (res.size() == 0) {
                return 4;
            }
            Character c2 = res.pollFirst();
        }
        return 0;
    }
}
