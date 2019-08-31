package com.zhoulychn.exam.alibaba;

import java.util.Scanner;


public class Main2 {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /**
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^
     **/
    static String getIndexAndLongest(String users, int k) {
        int bstart = users.length(), bmax = -1, bres = -1;
        int gres = -1;
        String res = "";
        for (int i = 0; i != bstart; i = i == users.length() - 1 ? 0 : ++i) {
            if (users.charAt(i) == 'b') {
                bstart = bstart == users.length() ? i : bstart;
                int t = 0;
                int m = i == users.length() - 1 ? 0 : i + 1;
                while (m != bstart && users.charAt(m) == 'g') {
                    t++;
                    m = m == users.length() - 1 ? 0 : ++m;
                }
                m = i == 0 ? users.length() - 1 : i - 1;
                while (m != bstart && users.charAt(m) == 'g') {
                    t++;
                    m = m == 0 ? users.length() - 1 : --m;
                }
                if (t > bmax) {
                    bmax = t;
                    bres = i;
                }
            }
            if (users.charAt(i) == 'b') {
                int m = i == users.length() - 1 ? 0 : i + 1, n = 0, t = 1;
                while (m != i && n <= k) {
                    if (users.charAt(m) == 'b')
                        t++;
                    else
                        n++;
                    m = m == users.length() - 1 ? 0 : ++m;
                }

                gres = Math.max(t, gres);
            }
        }
        res += (bres == -1 ? " " : bres) + " " + (gres == -1 ? " " : gres);
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String res;

        String _users;
        try {
            _users = in.nextLine();
        } catch (Exception e) {
            _users = null;
        }

        res = getIndexAndLongest(_users, in.nextInt());
        System.out.println(res);
    }
}
