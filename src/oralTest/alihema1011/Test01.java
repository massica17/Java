package oralTest.alihema1011;

import oralTest.InputUtils;

import javax.swing.*;

public class Test01 {
    public String solve() {
        int t = Integer.parseInt(InputUtils.getLine());
        while (t-- > 0) {
            int n = Integer.parseInt(InputUtils.getLine());
            String myAns = InputUtils.getLine();
            String ans = InputUtils.getLine();
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (myAns.charAt(i) == ans.charAt(i)) cnt++;
            }
            int cnt2 = n - cnt;
            if(cnt2 > cnt) return "on no";
            else if(cnt2 == cnt) return "(O.O)";
            else return "oh yes";
        }
        return "";
    }

    public static void main(String[] args) {
        Test01 test01 = new Test01();
        System.out.println(test01.solve());
    }
}
