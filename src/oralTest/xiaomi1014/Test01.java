package oralTest.xiaomi1014;

public class Test01 {
    public int solve(int[] nums){
        int n = nums.length;
        int[] order = new int[n + 2];
        int[] rev = new int[n + 2];
        if(n == 1) return 0;
        for(int i = 1; i <= n; i++) order[i] = nums[i - 1] == 1 ? order[i - 1] + 1 : 0;
        for(int i = n; i >= 1; i--) rev[i] = nums[i - 1] == 1 ? rev[i + 1] + 1 : 0;
        int ansMax = 0;
        for(int i = 1; i <= n; i++){
            ansMax = Math.max(ansMax, order[i - 1] + rev[i + 1]);
        }
        return ansMax;
    }
    public static void main(String[] args) {
        Test01 test01 = new Test01();
        test01.solve(new int[]{1, 1, 0, 1});
    }
}
