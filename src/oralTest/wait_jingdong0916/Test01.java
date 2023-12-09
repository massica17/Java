package oralTest.wait_jingdong0916;

import oralTest.InputUtils;

import java.util.Arrays;

public class Test01 {
    public int solve() {
        int[] arr = InputUtils.getArrayBySplit();
        int n = arr[0];
        int m = arr[1];
        int h = arr[2];
        int[] friend = InputUtils.getArrayBySplit();
        int[] fs = InputUtils.getArrayBySplit();
        int[] stair = InputUtils.getArrayBySplit();
        h += Arrays.stream(stair).max().orElse(Integer.MAX_VALUE);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            friend[i] += stair[fs[i] - 1];
            if (h > friend[i]) cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Test01 test01 = new Test01();
        System.out.println(test01.solve());
    }
}
