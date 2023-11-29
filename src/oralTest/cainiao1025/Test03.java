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
��Ŀ��С����һ������Ϊn������a����������[l,r]��ȨֵΪal|al+1|...|ar�����������������İ�λ������Ľ��.һ���� nx(n+ 1)/2 �������䣬С����֪����Ӧ��n(n +1)/2 ��Ȩֵ�У��ж��ٸ���ͬ��ȡֵ��

��������:

��һ��һ������ n����ʾ���鳤�ȡ� �ڶ���n������ a1,a2��...  ,an����ʾ����a��Ԫ�� 1��n��10^5 1 �� ai��10^9

������������һ����������ʾ��ͬ��ȡֵ������

ʾ����
 */