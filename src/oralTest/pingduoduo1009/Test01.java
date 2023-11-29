package oralTest.pingduoduo1009;

import oralTest.InputUtils;

import java.util.Arrays;

public class Test01 {
    public int solve() {
        int n = Integer.parseInt(InputUtils.getLine());
        int[] x = InputUtils.getArrayBySplit();
        int[] y = InputUtils.getArrayBySplit();
        Arrays.sort(x);
        Arrays.sort(y);
        int idx_x = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            boolean find = false;
            while (true) {
                if (idx_x >= n) break;
                if (x[idx_x] <= y[i]) idx_x++;
                else {
                    find = true;
                    break;
                }
            }
            if (find) {
                cnt++;
                idx_x++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Test01 test01 = new Test01();
        System.out.println(test01.solve());
    }
}
