package oralTest.xinhuasan1013;

import oralTest.InputUtils;

public class Test03 {

    public String solve() {
        String line = InputUtils.getLine();
        int ls = line.length();
        int maxLen = 0;
        String ans = "";
        for (int i = 0; i < ls; i++) {
            String temp;
            int cnt = 0;
            int left, right;
            if (i + 1 < ls && line.charAt(i) == line.charAt(i + 1)) {
                while ((left = i - cnt) >= 0 && (right = i + 1 + cnt) < ls && line.charAt(left) == line.charAt(right)) {
                    cnt++;
                }
                if (maxLen < cnt * 2) {
                    maxLen = cnt * 2;
                    ans = line.substring(i - cnt, i + 1 + cnt);
                }
            }
            cnt = 0;
            while ((left = i - cnt) >= 0 && (right = i + cnt) < ls && line.charAt(left) == line.charAt(right)) {
                cnt++;
            }
            if (maxLen < cnt * 2 + 1) {
                maxLen = cnt * 2 + 1;
                ans = line.substring(i - cnt + 1, i + cnt);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Test03 test03 = new Test03();
        System.out.println(test03.solve());
    }
}
