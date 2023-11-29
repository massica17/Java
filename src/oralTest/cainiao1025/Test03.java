package oralTest.cainiao1025;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Test03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int temp = nums[i] | nums[j];
                set.add(temp);
            }
        }
        System.out.println(set.size());
    }
}

/*
题目：小红有一个长度为n的数组a，记子区间[l,r]的权值为al|al+1|...|ar，即区间内所有数的按位或运算的结果.一共有 nx(n+ 1)/2 个子区间，小红想知道对应的n(n +1)/2 个权值中，有多少个不同的取值。

输入描述:

第一行一个整数 n，表示数组长度。 第二行n个整数 a1,a2，...  ,an，表示数组a的元素 1≤n≤10^5 1 ≤ ai≤10^9

输出描述：输出一个整数，表示不同的取值个数。

示例：
 */