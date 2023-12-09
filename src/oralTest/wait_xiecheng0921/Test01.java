package oralTest.wait_xiecheng0921;

import oralTest.InputUtils;

import java.util.Arrays;

public class Test01 {

    public void solve1(int n, int[] nums) {
        boolean[] hash = new boolean[n + 1];
        int[] ans = new int[n];
        ans[0] = nums[0] + 1;
        hash[ans[0]] = true;
        for (int i = 1; i < n; i++) {
            for (int j = n; j >= 1; j--) {
                if(!hash[j] && nums[i] != j){
                    ans[i] = j;
                    hash[j] = true;
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(ans));
    }

    public static void main(String[] args) {
        int n = InputUtils.getLineAsInt();
        int[] nums = InputUtils.getArrayBySplit();
        Test01 test01 = new Test01();
        test01.solve1(n, nums);
    }
}
