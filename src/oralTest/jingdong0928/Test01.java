package oralTest.jingdong0928;

import oralTest.InputUtils;

import java.net.InetAddress;
import java.util.HashSet;

public class Test01 {
    private final HashSet<Character> symmetry = new HashSet<>();

    public boolean isSymmetry(char lc, char rc) {
        if (lc == 'p' && rc == 'q') return true;
        if (lc == 'q' && rc == 'p') return true;

        if (lc == 'b' && rc == 'd') return true;
        if (lc == 'd' && rc == 'b') return true;

        return lc == rc && symmetry.contains(lc);
    }

    public void solve() {
        String str = "ilmnouvwx";
        for (int i = 0; i < str.length(); i++) {
            symmetry.add(str.charAt(i));
        }
        int n = InputUtils.getLineAsInt();
        while (n-- > 0) {
            char lc, rc;
            boolean yes = true;
            str = InputUtils.getLine();
            int ls = str.length();
            int left, right;
            int add = 0;
            if(ls % 2 == 0){
                left = ls / 2;
                right = left + 1;

            }
            else{
                left = ls / 2;
                right = left;
            }
            while (left - add >= 0){
                if(!isSymmetry(str.charAt(left), str.charAt(right))){
                    yes = false;
                    break;
                }
                add ++;
            }
            System.out.println(yes ? "Yes" : "No");
        }
    }

    public static void main(String[] args) {
        Test01 test01 = new Test01();
        test01.solve();
    }
}
