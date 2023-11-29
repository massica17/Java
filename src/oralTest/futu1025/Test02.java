package oralTest.futu1025;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int n = sc.nextInt();
        int[] m = new int[n];
        for (int i = 0; i < n; i++) m[i] = sc.nextInt();
        sc.close();
        Arrays.sort(m);
        int max = 0;
        int cur = 0;
        for(int u : m){
            if (a < u) {
                if (cur >= u - a) {
                    cur -= u - a;
                } else break;
            }
            cur++;
            max = Math.max(cur, max);
        }
        System.out.println(max);
    }
}
