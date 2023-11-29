package oralTest.pingduoduo1009;

import oralTest.InputUtils;
import oralTest.Main;

public class Test02 {
    public int solve(int[] nums, double k){
        int p0 = nums[0];
        int n = nums.length;
        int sum = 0;
        int ans = 0;
        for(int i = 1; i < n; i++){
            sum += nums[i - 1];
            double cur = (double) nums[i] / (double) sum;
            if(cur > k){
                int add = (int) Math.ceil((double) nums[i] / k - sum);
                ans += add;
                sum += add;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int t = Integer.parseInt(InputUtils.getLine());
        Test02 test02 = new Test02();
        while(t-- > 0){
            int[] arr = InputUtils.getArrayBySplit();
            int n = arr[0];
            int k = arr[1];
            int[] nums = InputUtils.getArrayBySplit();
            System.out.println(test02.solve(nums, (double) k / (double) 100));
        }
    }
}
