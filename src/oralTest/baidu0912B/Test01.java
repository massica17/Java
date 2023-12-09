package oralTest.baidu0912B;

import oralTest.InputUtils;

public class Test01 {
    public static void main(String[] args) {
        int n = InputUtils.getLineAsInt();
        int[] arr = InputUtils.getArrayBySplit();
        Test01 test01 = new Test01();
        System.out.println(test01.solve(arr[0], arr[1]));
    }

    private String solve(int n, int m) {
        return n % 2 == 0 && m % 2 == 0 ? "YES" : "NO";
    }
}
