package oralTest.zhangyue0927;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test02 {
    public int solve(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if (arr1[0] >= arr2[n2 - 1]) return arr1[0] - arr2[n2 - 1];
        if (arr1[n1 - 1] <= arr2[0]) return arr2[0] - arr1[n1 - 1];
        int i = 0, j = 0;
        int ans = Integer.MAX_VALUE;
        while (i < n1 && j < n2) {
            ans = Math.min(Math.abs(arr1[i] - arr2[j]), ans);
            if (arr1[i] <= arr2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Test02 test02 = new Test02();
        System.out.println(test02.solve(new int[]{1, 3, 15, 11, 2}, new int[]{23, 127, 235, 19, 8}));
    }
}
