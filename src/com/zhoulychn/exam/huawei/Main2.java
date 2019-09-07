package com.zhoulychn.exam.huawei;

import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int row = Integer.parseInt(in.nextLine());

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            list.add(in.nextLine());
        }

        System.out.println(calc(list));
    }

    private static String calc(ArrayList<String> list) {

        // key 表达式参数,list 可能为String 可能为Integer
        Map<String, ArrayList<Object>> map = new HashMap<>();
        String last = null;
        for (int i = 0; i < list.size(); i++) {
            String[] s = list.get(i).replace(" ", "").split("=");
            if (i == list.size() - 1) last = s[0];
            String[] params = s[1].split("\\+");
            map.put(s[0], new ArrayList<>());
            for (String param : params) {
                try {
                    int k = Integer.parseInt(param);
                    map.get(s[0]).add(k);
                } catch (Exception e) {
                    map.get(s[0]).add(param);
                }
            }
        }

        ArrayList<Object> res = new ArrayList<>();
        res.add(last);

        while (containsNA(res)) {
            ListIterator<Object> iterator = res.listIterator();
            while (iterator.hasNext()) {
                Object obj = iterator.next();
                if (obj instanceof Integer) continue;
                iterator.remove();
                if (obj instanceof String) {
                    if (map.get(obj) == null) return "NA";
                    ArrayList<Object> temp = map.get(obj);
                    for (Object o : temp) {
                        iterator.add(o);
                    }
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < res.size(); i++) {
            sum += (Integer) res.get(i);
        }
        return String.valueOf(sum);
    }

    private static boolean containsNA(ArrayList<Object> list) {
        for (Object o : list) {
            if (o instanceof String) return true;
        }
        return false;
    }
}
