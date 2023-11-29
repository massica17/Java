package oralTest.jingdong0923;

import oralTest.InputUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test02 {
    public int solve1(int n, int[] arr) {
        if (n <= 2) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 0;
        for (int i = 3; i <= n; i++) {
            if(arr[i - 3] <= arr[i - 2] && arr[i - 2] <= arr[i - 1]){
                dp[i] = dp[i - 2] + 1;
            }
            else dp[i] = dp[i - 2];
        }
        return Math.max(dp[n], dp[n - 1]);
    }

    public int solve2(int n, int[] arr){
        if(n <= 2) return 0;
        int curLen = 1;
        List<Integer> cnt = new ArrayList<>();
        for(int i = 1; i < n; i++){
            if(arr[i - 1] <= arr[i]) {
                curLen ++;
            }
            else{
                if(curLen >= 3) cnt.add(curLen);
                curLen = 1;
            }
        }
        if(curLen >= 3) cnt.add(curLen);
        int ans = 0;
        for(int len : cnt){
            ans += (len - 1) / 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = InputUtils.getLineAsInt();
        int[] arr = InputUtils.getArrayBySplit();
        Test02 test02 = new Test02();
        System.out.println(test02.solve1(n, arr));
        System.out.println(test02.solve2(n, arr));
    }
}
