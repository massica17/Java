package oralTest.wait_alibaba0923;

import oralTest.InputUtils;

public class Test02 {
    public static void main(String[] args) {
        String str = InputUtils.getLine();
        Test02 test02 = new Test02();
        System.out.println(test02.solve(str));
    }

    private int solve(String str) {
        int ls = str.length();
        if (ls <= 2) return 0;
        int ans = 0;
        int pre = 0;
        int cur = 1;
        char preChar = ' ';
        char curChar = str.charAt(0);
        for (int i = 1; i < ls; i++) {
            if (str.charAt(i) == curChar) {
                cur ++;
                if(cur == 2 && pre == 2){
                    ans ++;
                    cur--;
                }
                if(cur == 3){
                    ans ++;
                    cur --;
                }
            } else {
                pre = cur;
                preChar = curChar;
                cur = 1;
                curChar = str.charAt(i);
            }
        }
        return ans;
    }
}
