package oralTest.yongyou0918;

import oralTest.InputUtils;

import java.util.Arrays;

public class Test02 {
    public int solve(int m, int n){
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i <= m; i++) dp[i][0] = 1;
        for(int i = 0; i <= n; i++) dp[0][i] = 1;
        dp[0][0] = 0;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        int m = InputUtils.getLineAsInt();
        int n = InputUtils.getLineAsInt();
        Test02 test02 = new Test02();
        System.out.println(test02.solve(m, n));
    }
}
