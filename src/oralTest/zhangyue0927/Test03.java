package oralTest.zhangyue0927;

import oralTest.InputUtils;

import java.util.Arrays;

public class Test03 {

    public boolean isSymmetry(String str, int left, int right) {
        while (left <= right) {
            if (str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
            } else return false;
        }
        return true;
    }

    public int solve() {
        String str = InputUtils.getLine();
        int ls = str.length();
        int[] dp = new int[ls + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        boolean[][] isSymmetry = new boolean[ls][ls];
        for (int i = 0; i < ls; i++) {
            isSymmetry[i][i] = true;
            for (int j = i + 1; j < ls; j++) {
                isSymmetry[i][j] = isSymmetry(str, i, j);
            }
        }
        for(int i = 0; i < ls; i++){
            for(int j = i; j < ls; j ++){
                if(isSymmetry[i][j]){
                    dp[j + 1] = Math.min(dp[i] + 1, dp[j + 1]);
                }
            }
        }
        return dp[ls] - 1;
    }

    public static void main(String[] args) {
        Test03 test03 = new Test03();
        System.out.println(test03.solve());
    }
}
