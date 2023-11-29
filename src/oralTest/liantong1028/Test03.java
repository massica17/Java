package oralTest.liantong1028;

import java.util.Map;
import java.util.Scanner;

public class Test03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = sc.nextInt();
        sc.close();
        int temp = num;
        int sum = 0;
        while (temp > 0){
            sum += Math.pow(temp % 10, n);
            temp /= 10;
        }
        if(sum == num) System.out.println(1);
        else System.out.println(-1);
    }
}
