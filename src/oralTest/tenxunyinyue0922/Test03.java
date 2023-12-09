package oralTest.tenxunyinyue0922;

import oralTest.InputUtils;

public class Test03 {

    public int solve(String str) {
        long mod = (long) (7 + 1e9);
        int ls = str.length();
        long[] dp = new long[ls + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= str.length(); i++) {
            dp[i] = (dp[i] + dp[i - 1]) % mod;
            for (int j = 2; j <= i / 2; j++) {
                for (int k = 1; k + j - 1 <= i - j; k++) {
                    if (str.substring(k - 1, k + j - 1).equals(str.substring(i - j, i)))
                        dp[i] = (dp[i - j] + dp[i]) % mod;
                }
            }
        }
        return (int) dp[ls];
    }

    public static void main(String[] args) {
        Test03 test03 = new Test03();
        String str = InputUtils.getLine();
        System.out.println(test03.solve(str));
    }
}
