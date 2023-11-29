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
�������n������Ϊm���Ǻ�«��һ���Ǻ�«��һ���ַ�����ʾ���Ǻ�«�����Ϊ�����ַ������֮�͡� �ַ������Ϊ����ַ����ַ�'a'�Ĳ�ֵ����'a'�����Ϊ 0,'b'�����Ϊ 1.....,'z'�����Ϊ 25��

������������һ����һ�޶����Ǻ�«�����⴮�Ǻ�«������ һ���Ǻ�«��һ�޶����ҽ�������n-1���Ǻ�«��������Ǻ�«��ͬ������һ���Ǻ�«�����ת��������Ǻ�«��ͬ��������Ǻ�«���Ƕ�һ�޶��ġ������Ǻ�«"abc"��"cba"����Ϊ����ͬ�ģ�"abc"��"abc"Ҳ����Ϊ����ͬ�ġ�

�������֪�������Ե�����Ǻ�«�����������Ƕ��٣����Բ����κζ�һ�޶��Ǻ�«����
 */