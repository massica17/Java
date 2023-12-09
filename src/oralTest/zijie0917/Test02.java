package oralTest.zijie0917;

import oralTest.InputUtils;

import java.util.HashMap;

public class Test02 {
    public static void main(String[] args) {
        int n = InputUtils.getLineAsInt();
        int[] nums1 = InputUtils.getArrayBySplit();
        int[] nums2 = InputUtils.getArrayBySplit();
        Test02 test02 = new Test02();
        System.out.println(test02.solve(n, nums1, nums2));
    }

    private int solve(int n, int[] nums1, int[] nums2) {
        HashMap<Double, Integer> cnt = new HashMap<>();
        int add = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (nums1[i] == 0 && nums2[i] == 0) add++;
            else if(nums1[i] != 0){
                double cur = (double) (nums2[i]) / (double) (nums1[i]);
                cnt.put(cur, cnt.getOrDefault(cur, 0) + 1);
                if (cnt.get(cur) >= max) max = cnt.get(cur);
            }
        }
        return max + add;
    }
}
