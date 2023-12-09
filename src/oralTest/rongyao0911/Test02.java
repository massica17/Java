package oralTest.rongyao0911;

import oralTest.InputUtils;

public class Test02 {
    public String solve(String str) {
        int ls = str.length();
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (idx < ls) {
            char cur = str.charAt(idx);
            if (Character.isDigit(cur)) {
                int start = idx;
                while (start < ls && Character.isDigit(str.charAt(start))) start++;
                if(start < ls){
                    int time = Integer.parseInt(str.substring(idx, start));
                    while (time -- > 0) sb.append(str.charAt(start));
                }
                idx = start + 1;
            } else {
                sb.append(cur);
                idx++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = InputUtils.getLine();
        Test02 test02 = new Test02();
        String res = test02.solve(str);
        System.out.println(res);
    }
}
