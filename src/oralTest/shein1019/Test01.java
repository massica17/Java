package oralTest.shein1019;

import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cur = 100;
        int MAX = 150;
        int lastTime = 0;
        int ans = 0;
        while(n -- > 0){
            int time = sc.nextInt();
            int num = sc.nextInt();
            cur = Math.min(MAX, cur + (time - lastTime) / 100 * 10);
            if(num > cur) {
                ans += num - cur;
                cur = 0;
            }
            else{
                cur -= num;
            }
            lastTime = time;
        }
        sc.close();
        System.out.println(ans);
    }
}
