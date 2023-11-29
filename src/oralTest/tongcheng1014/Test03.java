package oralTest.tongcheng1014;

import oralTest.InputUtils;

public class Test03 {
    public int solve(int[] toll){
        int n = toll.length;
        int[][] dp = new int[n + 1][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        for(int i = 1;i <= n;i++) {
            dp[i][0] = dp[i-1][1];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][1]) + toll[i-1];
        }
        return Math.min(dp[n][0],dp[n][1]);
    }

    public static void main(String[] args) {
        Test03 test03 = new Test03();
        System.out.println(test03.solve(new int[]{1, 2, 3}));
    }
}
