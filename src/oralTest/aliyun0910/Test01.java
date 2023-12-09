package oralTest.aliyun0910;

import oralTest.InputUtils;

import java.util.Scanner;

public class Test01 {
    public int solve(int n, int m, int d, int[] p, int[] a) {
        int[] pos = new int[n + 1];
        for(int i = 1; i <= n; i++) pos[p[i]] = i;
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();
        int[] p = new int[n + 1];
        int[] a = new int[m + 1];
        for (int i = 1; i <= n; i++) p[i] = sc.nextInt();
        for (int i = 1; i <= m; i++) a[i] = sc.nextInt();
        Test01 test01 = new Test01();
        System.out.println(test01.solve(n, m, d, p, a));
    }
}
