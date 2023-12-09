package oralTest.yongyou0918;

import oralTest.InputUtils;

public class Test03 {
    public int solve(int[] nums1, int[] nums2, int k){
        int n = nums1.length;
        int[] diff = new int[n];
        int sum = 0;
        int positive = 0;
        for(int i = 0; i < n; i++){
            diff[i] = nums2[i] - nums1[i];
            if(diff[i] % k != 0) return -1;
            sum += diff[i];
            if(diff[i] > 0) positive += diff[i];
        }
        if(sum != 0) return -1;
        return positive / k;
    }

    public static void main(String[] args) {
        Test03 test03 = new Test03();
        int[] nums1 = InputUtils.getArrayBySplitByComma();
        int[] nums2 = InputUtils.getArrayBySplitByComma();
        int k = InputUtils.getLineAsInt();
        System.out.println(test03.solve(nums1, nums2, k));
    }
}
