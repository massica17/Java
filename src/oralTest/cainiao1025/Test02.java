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
С����һ������a��ÿ�ο��Խ����������ֲ�����

1.ѡ��һ���±�i����ai�Ӷ�����ai =ai+2��

2.ѡ��һ���±�i�����ai=ai+1����ai��ai+1��1����ai=ai+1��ai +1 =ai+1  +1;�����ܽ��� ������

С����Խ�����ǧ�β�����С����֪���ܷ�ͨ�����ɴβ���ʹ������ a������Ԫ����ȡ�

��������

��һ��һ������t����ʾ����������

������t�����ݣ�ÿ�����ݵ�һ��һ������ n����ʾ���鳤�ȡ� ������һ��n������ a1��a2��... ,an����ʾ���� a �ĳ�ʼֵ��

1��t��10   1��n��10^5  1��ai��10^9

�������

���t�У�ÿ��һ���ַ����������ʹ������ a ������Ԫ����ȣ������YES"�����������NO"��

ʾ��
 */
