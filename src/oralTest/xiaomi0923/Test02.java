package oralTest.xiaomi0923;

import oralTest.InputUtils;

import java.util.*;

public class Test02 {
    public void solve() {
        int[] input = InputUtils.getArrayBySplit();
        int n = input[0], m = input[1];
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i] = InputUtils.getArrayBySplit();
        }
        Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < m; i++) {
            int p = InputUtils.getLineAsInt();
            int cur = 0;
            for (int j = 0; j < n; j++) {
                if(arr[j][0] <= p && p <= arr[j][1]){
                    cur ^= arr[j][2];
                }
            }
            System.out.println(cur);
        }
    }

    public static void main(String[] args) {
        Test02 test02 = new Test02();
        test02.solve();
    }
}
