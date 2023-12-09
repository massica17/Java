package oralTest.baidu0912A;

import oralTest.InputUtils;
import oralTest.Main;

import java.util.Arrays;

public class Test01 {
    public int solve1(int n, int[] a, int[] b){
        int[][] pair = new int[n][2];
        for(int i = 0; i < n; i++){
            pair[i][0] = a[i];
            pair[i][1] = b[i];
        }
        Arrays.sort(pair, (o1, o2) -> o2[0] - o2[1] - (o1[0] - o1[1]));
        int mid = -1;
        for(int i = 0; i < n; i++){
            if(pair[i][0] > pair[i][1]) mid = i;
            else break;
        }
        int ans1 = 0, ans2 = 0;
        for(int i = 0; i <= mid; i++){
            ans1 += pair[i][0] - pair[i][1];
        }
        for(int i = mid + 1; i < n; i++){
            ans2 += pair[i][1] - pair[i][0];
        }
        return Math.max(ans1, ans2);
    }

    public int solve2(int n, int[] a, int[] b){
        int[] diff = new int[n];
        for(int i = 0; i < n; i++){
            diff[i] = a[i] - b[i];
        }
        int[] minDp = new int[n + 1];
        int[] maxDp = new int[n + 1];
        for(int i = 0; i < n; i++){
            minDp[i + 1] = Math.min(minDp[i], maxDp[i]) + diff[i];
            maxDp[i + 1] = Math.max(minDp[i], maxDp[i]) + diff[i];

            minDp[i + 1] = Math.min(minDp[i + 1], minDp[i]);
            maxDp[i + 1] = Math.max(maxDp[i + 1], maxDp[i]);
        }
        return Math.max(Math.abs(minDp[n]), Math.abs(maxDp[n]));
    }
    public static void main(String[] args) {
        int n = InputUtils.getLineAsInt();
        int[] a = InputUtils.getArrayBySplit();
        int[] b = InputUtils.getArrayBySplit();
        Test01 test01 = new Test01();
        System.out.println(test01.solve1(n, a, b));
        System.out.println(test01.solve2(n, a, b));
    }
}
