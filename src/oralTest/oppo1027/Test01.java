package oralTest.oppo1027;

import java.sql.Connection;
import java.util.*;

public class Test01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        sc.close();
        if(n == 2){
            System.out.println(0);
            return;
        }
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        if(nums[0] >= 0){
            for(int i = 2; i < n; i++){
                res.add(nums[i]);
            }
            res.add(nums[0] + nums[1]);
        }
        else if(nums[n - 1] <= 0){
            for(int i = 0; i < n - 2; i++){
                res.add(nums[i]);
            }
            res.add(nums[n - 1] + nums[n - 2]);
        }
        else if(nums[n - 1] > 0){
            for(int i = 1; i < n - 1; i++) {
                res.add(nums[i]);
            }
            res.add(nums[0] + nums[n - 1]);
        }
        res.sort(Integer::compareTo);
        System.out.println(Math.min(nums[n - 1] - nums[0], res.get(n - 2) - res.get(0)));
    }
}

/*
小欧有一个数组，他可以将任意两个元素删除，并将这两个元素之和放进数组。

小欧最多可以进行一次操作，他想让数组的极值 《数组的最大值减最小值)尽可能小，求最小的极值。

输入描述

第一行输入一个整数 n(2<=n<=10^5) 表示数组长度.

第二行输入n个整数表示数组a(1<=ai<=10^9)

输出描述

输出一个整数表示答案.
 */