package oralTest.wait_huawei0920;

import oralTest.InputUtils;

import java.util.Arrays;

public class Test01 {

    public void solve1(int n, int[] nums, int sn){
        int cnt = 0;
        if(nums[0] == sn){
            int idx = 0;
            while(idx + 1 < n && nums[idx + 1] == sn) idx ++;
            if(idx == n - 1){
                System.out.println(0 + " " + idx);
                return;
            }
            if(nums[n - 1] == sn){
                int idx2 = n - 1;
                while(idx2 - 1 >= 0 && nums[idx2 - 1] == sn) idx2--;
                System.out.println(idx2 + " " + idx);
            }
            else{
                System.out.printf("%d %d%n", 0, idx);
            }
        }
        else{
            int start = 0;
            for(int i = 0; i < n; i++) {
                if(nums[i] == sn) {
                    start = i;
                    break;
                }
            }
            int end = 0;
            for(int i = n - 1; i >= 0; i--){
                if(nums[i] == sn) {
                    end = i;
                    break;
                }
            }
            System.out.println(start + " " + end);
        }
    }

    public void solve2(int n, int[] nums, int sn){
        int min = Integer.MAX_VALUE;
        int start = 0;
        for(int i = 0; i < n; i++){
            if(min > nums[i]) {
                min = nums[i];
                start = i;
            }
        }
        int cur;
        int idx1 = -1;
        int idx2 = -1;
        for(int i = 0; i < n; i++){
            cur = (start + i) % n;
            if(nums[cur] == sn){
                if(idx1 == -1){
                    idx1 = cur;
                }
                idx2 = cur;
            }
        }
        System.out.println(idx1 + " " + idx2);
    }
    public static void main(String[] args) {
        Test01 test01 = new Test01();
        int n = InputUtils.getLineAsInt();
        int[] nums = InputUtils.getArrayBySplit();
        int sn = InputUtils.getLineAsInt();
        test01.solve2(n, nums, sn);
    }
}
