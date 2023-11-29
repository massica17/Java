package oralTest.qiuzhao360_1024;

import java.util.HashSet;
import java.util.Scanner;

public class Test01 {
    public static boolean canTrans(String s, String t) {
        int ls = s.length();
        int lt = t.length();
        if (ls > lt) return false;
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();
        HashSet<Character> has = new HashSet<>();

        for (int i = 0; i < ls; i++) {
            has.add(sCharArray[i]);
            if (sCharArray[i] != tCharArray[i]) {
                return false;
            }
        }
        for (int i = ls; i < lt; i++) {
            if (!has.contains(tCharArray[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        while (n-- > 0) {
            String s = scanner.nextLine().trim();
            String t = scanner.nextLine().trim();
            System.out.println(canTrans(s, t) ? "YES" : "NO");
        }
        scanner.close();
    }
}
