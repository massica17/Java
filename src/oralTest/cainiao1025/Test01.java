package oralTest.cainiao1025;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class Test01 {
    public static int getTimes(int n){
        int ans = 0;
        while(n > 0 && (n >> 1) << 1 == n){
            ans ++;
            n = n >> 1;
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int left = sc.nextInt();
        int right = sc.nextInt();
        sc.close();
        int ansMax = Integer.MIN_VALUE;
        for(int i = left; i <= right; i++){
            ansMax = Math.max(ansMax, getTimes(i));
        }
        System.out.println(ansMax);
    }
}
/*
小红喜欢偶数，即一个数从因数分解的角度来看，其中的偶数因子越多，她就越喜欢这个数。也就是x=PiXP2X...XPk，其中Pi 都是偶数，那么大的最大值就是小红对这个数的喜欢程度。小红想知道区间[l,r]的数中，小红对哪个数的喜欢程度最高，输出小红的喜欢程度。

输入描述

一行两个整数l,r，表示区间[l,r]。1≤l≤r≤10^9

输出描述

输出一个整数，表示小红对这个数的喜欢程度。

示例
 */