package oralTest.weizhongyinhang1008;

import oralTest.InputUtils;

public class Test03 {

    public void solve() {
        int n = Integer.parseInt(InputUtils.getLine());
        int[] array = InputUtils.getArrayBySplit();
        int min = Integer.MAX_VALUE;
        for (int a : array) {
            min = Math.min(min, a);
        }
        int cnt = 0;
        for (int a : array) {
            if (a == min) cnt++;
        }
        System.out.println(n - cnt);
    }

    public static void main(String[] args) {
        Test03 test03 = new Test03();
        test03.solve();
    }
}
