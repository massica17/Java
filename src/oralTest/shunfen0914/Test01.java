package oralTest.shunfen0914;

import oralTest.InputUtils;
import oralTest.Main;

import java.util.Arrays;

public class Test01 {
    public int solve(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int sqrt;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j >= 1; j--) {
                sqrt = (int) Math.sqrt(j);
                if (sqrt * sqrt == j) {
                    dp[i] = Math.min(dp[i], dp[i - j] + 4 * sqrt);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = InputUtils.getLineAsInt();
        Test01 test01 = new Test01();
        System.out.println(test01.solve(n));
    }
}
