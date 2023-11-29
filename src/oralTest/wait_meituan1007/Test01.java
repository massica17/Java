package oralTest.wait_meituan1007;

import oralTest.InputUtils;

public class Test01 {
    public int solve(){
        String str = InputUtils.getLine();
        int n = str.length();
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            max = Math.max(max, str.charAt(i) - '0');
        }
        return max;
    }
    public static void main(String[] args) {
        Test01 test01 = new Test01();
        System.out.println(test01.solve());
    }
}
