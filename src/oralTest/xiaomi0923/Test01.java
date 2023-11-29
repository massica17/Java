package oralTest.xiaomi0923;

import oralTest.InputUtils;

import java.net.Inet4Address;
import java.util.*;

public class Test01 {
    public List<Integer> solve(int n, int[] arr) {
        int cur = 0;
        List<Integer> res = new ArrayList<>();
        HashSet<Integer> keys = new HashSet<>();
        for (int i = 0; i < n; i++) {
            keys.add(arr[i]);
            while (keys.contains(cur + 1)) {
                res.add(i + 1);
                keys.remove(cur);
                cur++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n = InputUtils.getLineAsInt();
        int[] array = InputUtils.getArrayBySplit();
        Test01 test01 = new Test01();
        List<Integer> res = test01.solve(n, array);
        System.out.println(res);
    }
}
