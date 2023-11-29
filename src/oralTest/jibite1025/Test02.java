package oralTest.jibite1025;

import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        Test02.solve(str);
        char[] strCharArray = str.toCharArray();
        int n = str.length();
        if(n == 0) {
            System.out.println(0);
            return;
        }
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++){
            int cur = 0;
            for(int j = i; j >= 1; j--){
                cur += strCharArray[j - 1] - '0';
                if(cur % 3 == 0) dp[i] = Math.max(dp[i], dp[j - 1] + 1);
                else dp[i] = Math.max(dp[i], dp[j - 1]);
            }
        }
        System.out.println(dp[n]);
    }

    public static int solve(String str){
        int[] last = new int[]{-1, -1, -1};
        int n = str.length();
        if(n == 0) return 0;
        int[] dp = new int[n + 1];

        int sum = (str.charAt(0) - '0') % 3;
        last[sum] = 0;
        dp[0] = last[0] == 0 ? 1 : 0;
        for(int i = 1; i < n; i++){
            sum = (sum + str.charAt(i) - '0') % 3;
            int la = 0;
            if(last[sum] >= 0) la = dp[last[sum]];
            else if(sum == 0) la = 0;
            else la = -1;
            dp[i] = Math.max(dp[i - 1], la + 1);
            last[sum] = i;
        }
        return dp[n - 1];
    }
}

/*
小红喜欢 3 的倍数的数字，现在小红有一个长度为 n 的数字串，小红想通过分隔字符串的方式，获得一些子串，每个子串代表一个数字，那么小红最多能获得多少个数字是 3 的倍数呢？

比如，小红有数字 1123，那么可以分隔为[1,12,3]，这样获得了两个数字是 3 的倍数。

请注意，分隔后的数字串，不能包含前导零，比如 012 不能视为 12。可以分割出 0，0 也是 3 的倍数。

输入描述

第一行输入一个没有前导零的正整数 n，表示小红的数字。 1\leq n \leq 10^{10^5}

输出描述

输出一个整数，表示小红能够获得的 3 的倍数的数字的最大数量。
 */