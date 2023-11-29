package oralTest.jibite1025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] ints = Arrays.stream(br.readLine().trim().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = ints[0];
        int m = ints[1];
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = br.readLine().trim();
        }
        br.close();

        HashMap<String, Integer> map = new HashMap<>();
        for (String str : strs) {
            String rStr = new StringBuffer(str).reverse().toString();
            map.put(str, map.getOrDefault(str, 0) + 1);
            map.put(rStr, map.getOrDefault(rStr, 0) + 1);
        }
        int max = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                int cur = 0;
                String temp = entry.getKey();
                for (int i = temp.length() - 1; i >= 0; i--) {
                    cur += temp.charAt(i) - 'a';
                }
                max = Math.max(cur, max);
            }
        }
        System.out.println(max);
    }
}

/*
讨厌鬼有n串长度为m的糖葫芦，一串糖葫芦用一串字符串表示，糖葫芦的甜度为所有字符的甜度之和。 字符的甜度为这个字符与字符'a'的差值。即'a'的甜度为 0,'b'的甜度为 1.....,'z'的甜度为 25。

讨厌鬼现在想吃一根独一无二的糖葫芦，且这串糖葫芦甜度最大。 一个糖葫芦独一无二当且仅当另外n-1根糖葫芦都与这根糖葫芦不同，若有一根糖葫芦本身或翻转后与这根糖葫芦相同，则这根糖葫芦不是独一无二的。例如糖葫芦"abc"与"cba"被认为是相同的，"abc"和"abc"也被认为是相同的。

讨厌鬼想知道，他吃到这根糖葫芦串的甜度最大是多少？若吃不到任何独一无二糖葫芦，则
 */