package oralTest.tongcheng0916;

import oralTest.InputUtils;

import java.util.Arrays;

public class Test01 {
    public int solve(int m, int n, int[] s){
        int ns = s.length;
        if(n + n < ns || m + m > ns) return -1;
        if(m + n >= ns) return s[m - 1];
        else if(n + n >= ns) return s[ns - n - 1];
        return -1;
    }

    public static void main(String[] args) {
        int m = InputUtils.getLineAsInt();
        int n = InputUtils.getLineAsInt();
        int[] s = InputUtils.getArrayBySplit();
        Test01 test01 = new Test01();
        test01.solve(m, n, s);
    }
}
