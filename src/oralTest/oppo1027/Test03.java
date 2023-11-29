package oralTest.oppo1027;

import java.util.*;

public class Test03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ints = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = ints[0];
        int k = ints[1];
        String str = sc.nextLine();
        sc.close();
        if(n < 3 * k + 1) System.out.println(-1);
        int[][] dp = new int[n + 1][k + 1];
        int[][] min = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            Arrays.fill(min[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
            min[i][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if(i < 3 * j + 1){
                    dp[i][j] = Integer.MAX_VALUE;
                    continue;
                }
                int tt = 0;
                if(str.charAt(i - 1) != 'o') tt++;
                if(str.charAt(i - 2) != 'p') tt++;
                if(str.charAt(i - 3) != 'p') tt++;
                if(j == 1){
                    if(str.charAt(i - 4) != 'o') tt++;
                    dp[i][j] = dp[i - 4][j - 1] + tt;
                }
                else{
                    dp[i][j] = dp[i - 3][j - 1]  + tt;
                    if(str.charAt(i - 4) != 'o') tt++;
                    dp[i][j] = Math.min(min[i - 4][j - 1] + tt, dp[i][j]);
                }
                min[i][j] = Math.min(min[i - 1][j], dp[i][j]);
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 3 * k + 1; i <= n; i++){
            res = Math.min(res, dp[i][k]);
        }
        System.out.println(res);
    }
}

/*
小欧有一个仅由小写字母组成的字符串，小欧每次可以修改一个字母，求使得字符串中至少有k个子串是“oppo”的最小修改次数。

输入描述

第一行输入两个整数 n,k(1<=n<=10^4,1<=k<=200)

第二行输入一个长度为 n 的仅由小写字母组成的字符串。

输出描述

输出一个整数表示答案。

若是无解则输出 -1。

思路和代码
使用动态规划的方法，计算了在给定操作次数下，通过替换字符'o'为'p'，使得字符串中的字符'p'连续出现的最小次数。如果无法进行足够的替换操作，则输出-1。
 */