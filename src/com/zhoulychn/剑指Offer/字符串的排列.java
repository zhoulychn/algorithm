package com.zhoulychn.剑指Offer;

import java.util.ArrayList;
import java.util.LinkedList;

public class 字符串的排列 {

    private ArrayList<String> result = new ArrayList<>();

    private StringBuilder str = new StringBuilder("");


    public ArrayList<String> Permutation(String str) {
        if (str.length() == 0) return new ArrayList<>();
        LinkedList<Character> temp = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            temp.add(str.charAt(i));
        }
        backTrack(temp);
        return result;
    }

    private void backTrack(LinkedList<Character> temp) {
        if (temp.size() == 0) {
            if (!result.contains(str.toString())) result.add(str.toString());
            return;
        }
        for (int i = 0; i < temp.size(); i++) {
            Character c = temp.remove(i);
            str.append(c);
            backTrack(temp);
            temp.add(i, c);
            str.deleteCharAt(str.length() - 1);
        }
    }

    public static void main(String[] args) {
        new 字符串的排列().Permutation("abc");
    }

}
