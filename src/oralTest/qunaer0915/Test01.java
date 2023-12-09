package oralTest.qunaer0915;

import oralTest.InputUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Test01 {
    public void solve(int n, int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        int[][] pair = new int[map.size()][2];
        int cur = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pair[cur][0] = entry.getKey();
            pair[cur][1] = entry.getValue();
            cur++;
        }
        Arrays.sort(pair, Comparator.comparingInt(o -> o[1]));
        System.out.printf("%d", pair[0][0]);
        for (int i = 1; i < map.size(); i++) {
            System.out.printf(" %d", pair[i][0]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = InputUtils.getLineAsInt();
        int[] arr = InputUtils.getArrayBySplitByComma();
        Test01 test01 = new Test01();
        test01.solve(n, arr);
    }
}
