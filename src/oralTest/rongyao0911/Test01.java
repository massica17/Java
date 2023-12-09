package oralTest.rongyao0911;

import oralTest.InputUtils;

public class Test01 {
    private int[] arr = new int[]{3, 3, 3, 3, 3, 4, 3, 4};

    public String solve(String str) {
        int ls = str.length();
        char[] cs = str.toCharArray();
        for (int i = 0; i < ls; i++) {
            if (!Character.isLetter(cs[i])) continue;
            if (Character.isUpperCase(cs[i])) {
                char lowerCase = Character.toLowerCase(cs[i]);
                if (lowerCase == 'z') lowerCase = 'a';
                else lowerCase= 1;
                cs[i] = lowerCase;
            }
            int preSum = 0;
            for (int j = 0; j < 8; j++) {
                preSum += arr[j];
                if (cs[i] - 'a' + 1 <= preSum) {
                    cs[i] = (char) ('2' + j);
                    break;
                }
            }
        }
        return String.valueOf(cs);
    }

    public static void main(String[] args) {
        String line = InputUtils.getLine();
        Test01 test01 = new Test01();
        System.out.println(test01.solve(line));
    }
}
