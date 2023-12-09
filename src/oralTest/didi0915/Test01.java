package oralTest.didi0915;

import oralTest.InputUtils;

import java.util.Arrays;

public class Test01 {
    public int solve(int n, int k, int[] x){
        int left = 1;
        int right = x[n - 1];
        int ans = Integer.MIN_VALUE;
        while (left <= right){
            int mid = (left + right) / 2;
            if(check(n, x, k, mid)){
                left = mid + 1;
                ans = mid;
            }
            else right = mid - 1;
        }
        return ans;
    }

    private boolean check(int n, int[] x, int k, int mid) {
        int pre = x[0];
        int cnt = 1;
        for(int i = 1; i < n; i++){
            if(x[i] - pre >= mid){
                pre = x[i];
                cnt++;
            }
        }
        return cnt >= k;
    }

    public static void main(String[] args) {
        int[] arr = InputUtils.getArrayBySplit();
        int n = arr[0];
        int k = arr[1];
        int[] x = InputUtils.getArrayBySplit();
        Test01 test01 = new Test01();
        System.out.println(test01.solve(n, k, x));
    }
}
