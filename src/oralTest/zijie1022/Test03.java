package oralTest.zijie1022;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Test03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++){
            preSum[i] = preSum[i - 1] + scanner.nextInt();
        }
        int[][] area = new int[m][2];
        for (int i = 0; i < m; i++) {
            area[i][0] = scanner.nextInt();
            area[i][1] = scanner.nextInt();
        }
        scanner.close();
        Arrays.sort(area, Comparator.comparingInt(value -> value[1]));
        int[] dp = new int[n + 1];
        int ansMax = 0;
        int j = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            if(i == area[j][1]){
                dp[i] = Math.max(dp[area[j][0] - 1] + preSum[area[j][1]] - preSum[area[j][0] - 1], dp[i]);
                j++;
            }
        }
        System.out.println(dp[n]);
    }
}
