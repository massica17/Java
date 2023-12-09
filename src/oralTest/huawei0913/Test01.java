package oralTest.huawei0913;

import oralTest.InputUtils;

public class Test01 {
    public int solve(int n, int k, int[] arr) {
        int preSum = 0;
        int ans = 0;
        int left = 0;
        for (int i = 0; i < n; i++) {
            preSum = arr[i] + left;
            int t1 = preSum / k;
            int t2 = preSum % k;
            if (t1 == 0 && left != 0) {
                t1++;
                t2 = 0;
            }
            ans += t1;
            left = t2;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = InputUtils.getArrayBySplit();
        int[] nums = InputUtils.getArrayBySplit();
        Test01 test01 = new Test01();
        System.out.println(test01.solve(arr[0], arr[1], nums));
    }
}
