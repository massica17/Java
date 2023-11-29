package oralTest.wait_meituan1007;

import oralTest.InputUtils;

public class Test03 {
    public boolean delete(int n, String str, int ls) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < ls; i++){
            if( ((n >> i) & 1) == 1 && (n >> (i + 1)) == 1) return false;
        }
        for(int i = 0; i < ls; i++){
            if(((n >> (ls - 1 - i) & 1) != 1)){
                sb.append(str.charAt(i));
            }
        }
        return sb.indexOf("mei") != -1;
    }

    public int solve() {
        String str = InputUtils.getLine();
        int ls = str.length();
        int all = (int) Math.pow(2, ls);
        int cnt = 0;
        for (int i = 0; i < all; i++) {
            if (delete(i, str, ls)) cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Test03 test03 = new Test03();
        System.out.println(test03.solve());
    }
}
