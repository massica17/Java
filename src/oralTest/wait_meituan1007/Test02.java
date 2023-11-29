package oralTest.wait_meituan1007;

import oralTest.InputUtils;

import java.util.Arrays;

public class Test02 {
    public int solve() {
        int n = Integer.parseInt(InputUtils.getLine());
        int[] an = InputUtils.getArrayBySplit();
        int[] bn = InputUtils.getArrayBySplit();
        Arrays.sort(an);
        Arrays.sort(bn);
        int ax = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            while (true) {
                if(ax >= n) break;
                if (an[ax] < bn[i]) ax++;
                else {
                    ax++;
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Test02 test02 = new Test02();
        System.out.println(test02.solve());
    }
}
