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
С��ϲ��ż������һ�����������ֽ�ĽǶ����������е�ż������Խ�࣬����Խϲ���������Ҳ����x=PiXP2X...XPk������Pi ����ż������ô������ֵ����С����������ϲ���̶ȡ�С����֪������[l,r]�����У�С����ĸ�����ϲ���̶���ߣ����С���ϲ���̶ȡ�

��������

һ����������l,r����ʾ����[l,r]��1��l��r��10^9

�������

���һ����������ʾС����������ϲ���̶ȡ�

ʾ��
 */