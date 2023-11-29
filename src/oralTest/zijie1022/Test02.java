package oralTest.zijie1022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        x -= (n + 1) * n / 2;
        if (x < 0) System.out.println(-1);
        else {
            int[] ans = new int[n];
            Arrays.fill(ans, 1);
            for (int i = n; i >= 1; i--) {
                if(x - i == 0){
                    x -= i;
                    ans[n - i] += 1;
                    break;
                }
                else if(x - i > 0){
                    x -= i;
                    ans[n - i] += 1;
                }
            }
            if(x != 0) System.out.println(-1);
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < n; i++){
                if(i == 0) sb.append(ans[i]);
                else sb.append(" ").append(ans[i]);
            }
            System.out.println(sb);
        }
    }
}

/*
给定两个正整数n，x，小红希望你构造一个长度为n的数组，满足 ∑（n,i=1）sum(i) = x。

sum(i)即数组的前i项之和。换言之，小红希望你构造一个长度为n的数组满足，n个前缀和之和等于t。

要求数组的元素仅由1和2组成。
 */