package oralTest.baidu0912B;

import oralTest.InputUtils;

import java.util.HashMap;
import java.util.HashSet;

public class Test02 {
    public void solve(int n, int k, int[] nums) {
        int[] window = new int[k + 1];
        if (k > n) {
            System.out.println("NO");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (i >= k) {
                window[nums[i - k]]--;
            }
            window[nums[i]]++;
            if (i >= k - 1) {
                int zero = 0;
                int two = 0;
                int cnt = 0;
                for (int j = 1; j <= k; j++) {
                    if (window[i] != 1) {
                        if (window[i] == 0) zero = i;
                        if (window[i] >= 1) two = i;
                        cnt++;
                        if (cnt >= 2) break;
                    }
                }
                if (cnt > 1) continue;
                if(cnt == 0) {
                    System.out.println("YES");
                    System.out.println(0);
                }
                int zero_idx = -1;
                int two_idx = -1;
                for(int j = 0; j < n; j++){
                    if(j >= i - k + 1 && j <= i && nums[j] == two) two_idx = j;
                    if((j <= i - k || j > i) && nums[j] == zero) zero_idx = j;
                }
                if(zero_idx != -1 && two_idx != -1){
                    System.out.println("YES");
                    System.out.println(1);
                    System.out.println(zero_idx + " " + two_idx);
                    return;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = InputUtils.getArrayBySplit();
        int[] nums = InputUtils.getArrayBySplit();
        Test02 test02 = new Test02();
        test02.solve(arr[0], arr[1], nums);
    }
}
