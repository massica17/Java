package oralTest.cainiao1025;

import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = scanner.nextInt();
                System.out.println(solve(nums));
            }
        }
    }

    private static boolean solve(int[] nums) {
        int odd = 0, even = 0;
        int ln = nums.length;
        for (int i = 0; i < ln; ) {
            int j = i;
            while (j < ln && nums[j] % 2 == nums[i] % 2) {
                j++;
            }
            if((j - i) % 2 == 1){
                if(nums[i] % 2 == 0){
                    even++;
                }
                else odd ++;
            }
            i = j;
        }
        if(odd > 0) return even == 0;
        else return true;
    }
}

/*
小红有一个数组a，每次可以进行以下两种操作：

1.选择一个下标i，将ai加二，即ai =ai+2。

2.选择一个下标i，如果ai=ai+1，将ai和ai+1加1，即ai=ai+1，ai +1 =ai+1  +1;否则不能进行 操作。

小红可以进行若千次操作，小红想知道能否通过若干次操作使得数组 a中所有元素相等。

输入描述

第一行一个整数t，表示数据组数。

接下来t组数据，每组数据第一行一个整数 n，表示数组长度。 接下来一行n个整数 a1，a2，... ,an，表示数组 a 的初始值。

1≤t≤10   1≤n≤10^5  1≤ai≤10^9

输出描述

输出t行，每行一个字符串，如果能使得数组 a 中所有元素相等，输出“YES"，否则输出“NO"。

示例
 */
