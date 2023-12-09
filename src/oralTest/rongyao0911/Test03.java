package oralTest.rongyao0911;

import java.util.Scanner;

public class Test03 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String s = sc.nextLine();
        String [] data = s.split("\\|");
        int time = Integer.parseInt(data[1]);
        int rate = Integer.parseInt(data[2]);
        int minute = time / 60;
        if (time % 60 != 0) minute++;
        int f1 = fun1(minute, rate);
        int kb = Integer.parseInt(data[3]);
        int dataRate = Integer.parseInt(data[4]);
        double mb = kb * 1.0/ 1024;
        int f2 = (int)(fun2(mb) * 1024 / 10 * dataRate / 10);
        System.out.println(f1 + f2);
    }

    public static int fun1(int minute, int rate) {
        double count = 0;
        if (minute <= 1) return 0;
        if (minute > 5) {
            count += (5 - 1) * rate * 1.5;
        } else {
            count += (minute - 1) * rate * 1.5;
            return  (int) (count / 10);
        }
        if (minute > 10) {
            count += (10 - 5) * rate;
        } else {
            count += (minute - 5) * rate;
            return  (int) (count / 10);
        }
        if (minute > 20) {
            count += (20 - 10) * rate * 0.5;
        } else {
            count += (minute - 10) * rate * 0.5;
            return  (int) (count / 10);
        }
        count += (minute - 20) * rate * 0.2;
        return (int) (count / 10);
    }

    public static double fun2(double mb) {
        double tmp = mb;
        int all = 0;
        if (tmp >= 100) {
            all += 25;
        } else {
            return tmp;
        }
        if (tmp <= 125) {
            return 100;
        }
        tmp -= 25;
        if (tmp >= 200) {
            all += 100;
        } else {
            return mb - all;
        }
        if (tmp <= 300) {
            return 200;
        }
        tmp -= 100;
        if (tmp >= 500) {
            double c = tmp - 500;
            int i = (int) (c / 200);
            all += i * 100;
            if (c % 200 >= 100) {
                all += c % 100;
            }
        } else {
            return mb - all;
        }
        return mb - all;
    }
}
