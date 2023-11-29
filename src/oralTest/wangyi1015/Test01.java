package oralTest.wangyi1015;

import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int num = sc.nextInt();
            System.out.println((num + 5) / 6);
        }
    }
}
