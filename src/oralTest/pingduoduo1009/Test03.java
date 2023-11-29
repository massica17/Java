package oralTest.pingduoduo1009;

import oralTest.InputUtils;

import java.util.Spliterator;

public class Test03 {
    public int solve() {
        int t = Integer.parseInt(InputUtils.getLine());
        while (t-- > 0) {
            int ans = 0;
            int m = Integer.parseInt(InputUtils.getLine());
            String str = InputUtils.getLine();
            int ls = str.length();
            char[] chars = str.toCharArray();
            boolean[] use = new boolean[ls];
            int three = 0, two = 0, one = 0;
            for (int i = 0; i < ls; ) {
                if (i + 2 < ls && chars[i] == 'P' && chars[i + 1] == 'D' && chars[i + 2] == 'D') {
                    three++;
                    i += 3;
                    use[i] = true;
                    use[i + 1] = true;
                    use[i + 2] = true;
                } else i++;
            }
            for (int i = 0; i < ls; ) {
                if (i + 1 < ls && !use[i] && !use[i + 1]) {
                    if (chars[i] == 'P' && chars[i + 1] == 'D' ||
                            chars[i] == 'D' && chars[i + 1] == 'D') {
                        two++;
                        use[i] = true;
                        use[i + 1] = true;
                        i += 2;
                    }
                    else i++;
                }
                else i++;
            }
            for (int i = 0; i < ls; i++) {
                if (!use[i]) one++;
            }
            ans += three;
            if(m >= two){
                ans += two;
                m -= two;
            }
            else{
                ans += m;
                m -= m;
            }
            if(m >= 2 * one){
                ans += one;
                m -= 2 * one;
            }
            else{
                ans += m / 2;
                m -= m / 2;
            }
            if(m > 0){
                ans += m / 3;
            }
            System.out.println(ans);
        }
        return 0;
    }

    public static void main(String[] args) {
        Test03 test03 = new Test03();
        test03.solve();
    }
}
