package oralTest.alifeizhu1028;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Dish {
    public int price;
    public boolean has;

    public int getPrice() {
        return price;
    }
}

public class Test01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        String hasStr = sc.next();
        Dish[] dishes = new Dish[n];
        for (int i = 0; i < n; i++) {
            dishes[i].price = sc.nextInt();
            if (hasStr.charAt(i) == '1') dishes[i].has = true;
            else dishes[i].has = false;
        }
        sc.close();
        Arrays.sort(dishes, Comparator.comparingInt(Dish::getPrice));
        int cnt = 0;
        int price = 0;
        for (int i = 0; i < n; i++) {
            if (cnt < k) {
                if (!dishes[i].has) {
                    price += dishes[i].price;
                    cnt++;
                } else {
                    if (m > 0) {
                        price += dishes[i].price;
                        cnt++;
                        m--;
                    }
                }
            } else {
                break;
            }
        }
        if(cnt < k) System.out.println(-1);
        else System.out.println(price);
    }
}

/*
小红来到了一家饭馆，该饭馆一共有n道菜，第i道菜的价格为ai。其中有一些菜里有蘑菇。

小红希望点k道菜，总价格越小越好。由于小红不喜欢吃蘑菇，她希望点的菜最多有m道菜中包含磨菇。小红想知道最终最小的总价格是多少。

输入描述

第一行输人三个正整数n,m,k，空格隔开。

第二行输入一个01串，第i个字符是0代表该菜不包含蘑菇，是1代表包含蘑菇。

第三行输入n个正整数，第i个数代表a[i]

1≤m≤k≤n< 10^5

1≤a[i]≤10^9

输出描述

一行，代表最小总价格。如果选不出来输出-1.
 */