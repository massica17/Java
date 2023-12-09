package oralTest.baidu0912A;

import oralTest.InputUtils;

import java.util.Arrays;

public class Test02 {
    public int solve(int n, int m, int[] a, int[][] lr) {
        int left = 0, right = m - 1;
        int[] tempA = new int[n + 1];
        while (left <= right) {
            int mid = (left + right) >> 1;
            Arrays.fill(tempA, 0);
            for (int i = 0; i < mid; i++) {
                tempA[lr[i][0] - 1] ++;
                tempA[lr[i][1]] --;
            }
            boolean check = true;
            for(int i = 0; i < n; i++){
                if(i > 0) tempA[i] += tempA[i - 1];
                if(tempA[i] > a[i]){
                    check = false;
                    break;
                }
            }
            if(check) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }

    public static void main(String[] args) {
        Test02 test02 = new Test02();
        int[] arr = InputUtils.getArrayBySplit();
        int n = arr[0];
        int m = arr[1];
        int[] a = InputUtils.getArrayBySplit();
        int[][] lr = new int[m][2];
        for (int i = 0; i < m; i++) {
            lr[i] = InputUtils.getArrayBySplit();
        }
        System.out.println(test02.solve(n, m, a, lr));
    }
}
