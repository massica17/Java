package oralTest.shunfen0914;

import oralTest.InputUtils;

public class Test02 {

    public static void main(String[] args) {
        int[] arr = InputUtils.getArrayBySplit();
        int[] nums = InputUtils.getArrayBySplit();
        Test02 test02 = new Test02();
        test02.solve(arr[0], arr[1], nums);
    }

    private void solve(int n, int k, int[] nums) {
        for (int i = 0; i < n - 1; i++) {
            if (k <= 0) break;
            if (k >= nums[i]) {
                k -= nums[i];
                nums[i] = 0;
                nums[n - 1] += nums[i];
            }
            else {
                nums[i] -= k;
                nums[n - 1] += k;
                k = 0;
            }
        }
        System.out.printf("%d", nums[0]);
        for(int i = 1; i < n; i++){
            System.out.printf(" %d", nums[i]);
        }
        System.out.println();
    }
}
