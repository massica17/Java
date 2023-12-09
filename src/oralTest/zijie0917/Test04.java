package oralTest.zijie0917;

import oralTest.InputUtils;

import java.util.Arrays;

public class Test04 {
    public int solve(String s, String t, int k) {
        int mod = (int) (7 + 1e9);
        int ls = s.length();
        int lt = t.length();
        if (ls != lt) return 0;
        int start = 0;
        for (int i = 0; i < ls; i++) {
            boolean find = true;
            for (int j = 0; j < ls; j++) {
                if (s.charAt((j + i) % ls) != t.charAt((j) % ls)) {
                    find = false;
                    break;
                }
            }
            if (find) {
                start = i;
                break;
            }
        }
        int[] dpCur = new int[ls * k + 1];
        int[] dpPre;
        for (int i = 1; i <= ls - 1; i++) {
            dpCur[i] = 1;
        }
        dpPre = Arrays.copyOf(dpCur, dpCur.length);
        Arrays.fill(dpCur, 0);
        for (int i = 2; i <= k; i++) {
            for (int j = i; j <= i * (ls - 1); j++) {
                for (int cur = 1; cur <= ls - 1; cur++) {
                    if (j - cur <= 0) break;
                    dpCur[j] += dpPre[j - cur];
                    dpCur[j] %= mod;
                }
            }
            dpPre = Arrays.copyOf(dpCur, dpCur.length);
            Arrays.fill(dpCur, 0);
        }
        int ans = 0;
        for(int i = 1; i <= ls * k; i++){
            if((i - start) % ls == 0) ans += dpPre[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = InputUtils.getLine();
        String t = InputUtils.getLine();
        int k = InputUtils.getLineAsInt();
        Test04 test04 = new Test04();
        System.out.println(test04.solve(s, t, k));
    }
}
