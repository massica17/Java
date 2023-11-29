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
Сŷ��һ�����飬�����Խ���������Ԫ��ɾ��������������Ԫ��֮�ͷŽ����顣

Сŷ�����Խ���һ�β���������������ļ�ֵ ����������ֵ����Сֵ)������С������С�ļ�ֵ��

��������

��һ������һ������ n(2<=n<=10^5) ��ʾ���鳤��.

�ڶ�������n��������ʾ����a(1<=ai<=10^9)

�������

���һ��������ʾ��.
 */