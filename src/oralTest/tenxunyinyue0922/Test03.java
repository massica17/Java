package oralTest.tenxunyinyue0922;

import oralTest.InputUtils;

public class Test03 {

    public int solve(String str) {
        long mod = (long) (7 + 1e9);
        int ls = str.length();
        long[] dp = new long[ls + 1];
        dp[1] = 1;
        for (int i = 1; i <= ls; i++) {
            dp[i] = dp[i - 1];
            for(int j = i - 1; j >= 1; j--){
                String suffix = str.substring(j, i);
                String prefix = str.substring(0, j);
                if(prefix.contains(suffix)){
                    dp[i] += dp[j];
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
