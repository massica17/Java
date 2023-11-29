package oralTest.jingdong0923;

import oralTest.InputUtils;

import java.util.Arrays;
import java.util.Scanner;

public class Test01 {

    public int solve(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] red = new int[n];
        for(int i = 0; i < n; i++){
            red[i] = sc.nextInt();
        }

        int[] blue = new int[n];
        int b, c;
        for(int i = 0; i < n; i++){
            b = sc.nextInt();
            c = sc.nextInt();
            blue[i] = red[b - 1] + red[c - 1];
        }
        sc.close();
        int ans = 0;
        for(int i = 0; i < n; i++){
            ans += Math.min(red[i], blue[i]);
        }
        return ans;
    }
    public static void main(String[] args) {
        Test01 test01 = new Test01();
        System.out.println(test01.solve());
    }
}
