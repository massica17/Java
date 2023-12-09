package oralTest.wait_xiecheng0921;

import oralTest.InputUtils;

public class Test03 {
    public boolean cntOne(int[] nums1) {
        int n = nums1.length;
        for (int j : nums1) {
            if (j > 1) return false;
        }
        return true;
    }

    public int solve1(int n, int m, char[][] map) {
        int[][][] cnt = new int[n + 1][m + 1][26];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                cnt[i][j] = add(cnt[i - 1][j], cnt[i][j - 1], map[i - 1][j - 1], cnt[i - 1][j - 1]);
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int h_i = 1; h_i < i; h_i++) {
                    for (int w_j = 1; w_j < j; w_j++) {
                        int[] reduce = reduce(cnt[i][j], cnt[i][w_j - 1], cnt[h_i - 1][j], cnt[h_i - 1][w_j - 1]);
                        if(cntOne(reduce)) ans ++;
                    }
                }
            }
        }
        return ans;
    }

    private int[] add(int[] nums1, int[] nums2, char c, int[] nums3) {
        int n = nums1.length;
        int[] res = new int[n];
        for(int i = 0; i < n; i++){
            res[i] = nums1[i] + nums2[i] - nums3[i];
        }
        res[c - 'a']++;
        return res;
    }

    private int[] reduce(int[] nums1, int[] nums2, int nums3[], int nums4[]){
        int[] res = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            res[i] = nums1[i] - nums2[i] - nums3[i] + nums4[i];
        }
        return res;
    }


    public static void main(String[] args) {
        int[] array = InputUtils.getArrayBySplit();
        int n = array[0];
        int m = array[1];
        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) map[i] = InputUtils.getCharArrayBySplit();
        Test03 test03 = new Test03();
        System.out.println(test03.solve1(n, m, map));
    }
}
