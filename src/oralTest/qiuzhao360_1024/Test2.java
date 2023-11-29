package oralTest.qiuzhao360_1024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test2 {
    public static int solve(int n, String str){
        long mod = (long) (7 + 1e9);
        if(n <= 1) return n;
        long[] dp = new long[n + 1];
        char[] strCharArray = str.toCharArray();
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            int temp = (strCharArray[i - 2] - '1') * 10 + strCharArray[i - 1] - '1';
            if(temp <= 26 && temp >= 11) {
                dp[i] = (dp[i - 1] % mod + dp[i - 2] % mod) % mod;
            }
            else dp[i] = dp[i - 1];
        }
        return (int) dp[n];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        String str = bufferedReader.readLine().trim();
        System.out.println(solve(n, str));
    }
}
