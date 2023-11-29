package oralTest.xinhuasan1013;

import java.util.Arrays;
import java.util.HashMap;

public class Test02 {
    public int[] solve(int[] nums, int target){
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(map.containsKey(target - nums[i])){
                return new int[]{i, map.get(target - nums[i])};
            }
            else{
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }
    public static void main(String[] args) {
        Test02 test02 = new Test02();
        System.out.println(Arrays.toString(test02.solve(new int[]{1, 2, 3}, 3)));
    }
}
