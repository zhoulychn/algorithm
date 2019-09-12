package com.zhoulychn.exam.sougou;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main1 {

    class MyMap<K, V> extends LinkedHashMap<String, Integer> {
        private int n;

        public MyMap(int n) {
            super(n, 0.75F, true);
            this.n = n;
        }

        public Integer put(String key, Integer value) {
            Integer v = get(key);
            if (v != null && v < value) {
                System.out.println(key + " " + value);
            }
            put(key, value);
            return value;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() == n;
        }
    }
}
