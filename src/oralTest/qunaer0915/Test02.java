package oralTest.qunaer0915;

import oralTest.InputUtils;

public class Test02 {
    public int solve(int n, int k, int[] nums) {
        int left = 0;
        int right = nums.length;
        boolean flag = false;
        while (left < right) {
            int mid = left - (left - right) / 2;
            if (nums[mid] >= k) {
                right = mid;
                flag = true;
            } else if (nums[mid] < k) {
                left = mid + 1;
            }
        }
        if (flag) {
            return left + 1;
        } else {
            return nums.length + 1;
        }
    }

    public static void main(String[] args) {
        int n = InputUtils.getLineAsInt();
        int k = InputUtils.getLineAsInt();
        int[] nums = InputUtils.getArrayBySplitByComma();
        Test02 test02 = new Test02();
        System.out.println(test02.solve(n, k, nums));
    }
}
