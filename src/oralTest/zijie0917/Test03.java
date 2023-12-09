package oralTest.zijie0917;

import oralTest.InputUtils;

public class Test03 {
    public int solve(int n, int k, int[][] nums) {
        for (int i = 1; i < n; i++) {
            nums[0][i] = nums[0][i - 1] ^ nums[0][i];
            nums[1][i] = nums[1][i - 1] ^ nums[1][i];
            nums[2][i] = nums[2][i - 1] ^ nums[2][i];
        }
        int max = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int m = 0; m <= n; m++) {
                    if (i + j + m <= k){
                        int cur = 0;
                        if(i >= 1) cur |= nums[0][i - 1];
                        if(j >= 1) cur |= nums[1][j - 1];
                        if(m >= 1) cur |= nums[2][m - 1];
                        max = Math.max(cur, max);
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = InputUtils.getArrayBySplit();
        int n = arr[0];
        int k = arr[1];
        int[][] nums = new int[3][n];
        nums[0] = InputUtils.getArrayBySplit();
        nums[1] = InputUtils.getArrayBySplit();
        nums[2] = InputUtils.getArrayBySplit();
        Test03 test03 = new Test03();
        System.out.println(test03.solve(n, k, nums));
    }
}
