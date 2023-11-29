package oralTest.liantong1028;

import java.util.HashMap;

public class Test01 {
    public int[] findTarget(int[] nums, int target) {
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

    }
}
