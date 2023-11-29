package oralTest.wangyi1015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().trim();
        int ls = str.length();
        int[] dp = new int[ls + 1];
        char[] array = str.toCharArray();
        dp[0] = 0;
        if(ls == 0) {
            System.out.println(0);
            return;
        }
        dp[1] = array[0] - '0';
        if(ls == 1){
            System.out.println(dp[1]);
            return;
        }
        dp[2] = (array[0] - '0') * 10 + (array[1] - '0');
        if (ls == 2) {
            System.out.println(dp[2]);
            return;
        }
        int one;
        int two;
        int thr;
        for(int i = 3; i <= ls; i++){
            one = array[i - 1] - '0';
            two = one + (array[i - 2] - '0') * 10;
            thr = (array[i - 3] - '0') * 100 + two;
            dp[i] = Math.max(dp[i - 1] + one, dp[i]);
            dp[i] = Math.max(dp[i - 2] + two, dp[i]);
            if(thr <= 100) dp[i] = Math.max(dp[i - 3] + thr, dp[i]);
        }
        System.out.println(dp[ls]);
    }
}
