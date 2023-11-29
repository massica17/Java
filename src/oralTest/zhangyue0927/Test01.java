package oralTest.zhangyue0927;

import oralTest.InputUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test01 {
    public void solve(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int n = nums.length;
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        int[][] cnt = new int[hashMap.size()][2];
        int cur = 0;
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            cnt[cur][0] = entry.getKey();
            cnt[cur][1] = entry.getValue();
            cur++;
        }
        Arrays.sort(cnt, (o1, o2) -> o2[1] - o1[1]);
        for(int i = 0; i < k; i++){
            if(i == 0) System.out.print(cnt[0][0]);
            else System.out.printf(" %d", cnt[i][0]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = InputUtils.getArrayBySplit();
        int k = Integer.parseInt(InputUtils.getLine());
        Test01 test01 = new Test01();
        test01.solve(nums, k);
    }
}
