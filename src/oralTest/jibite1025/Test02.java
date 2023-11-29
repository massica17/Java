package oralTest.jibite1025;

import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        Test02.solve(str);
        char[] strCharArray = str.toCharArray();
        int n = str.length();
        if(n == 0) {
            System.out.println(0);
            return;
        }
        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++){
            int cur = 0;
            for(int j = i; j >= 1; j--){
                cur += strCharArray[j - 1] - '0';
                if(cur % 3 == 0) dp[i] = Math.max(dp[i], dp[j - 1] + 1);
                else dp[i] = Math.max(dp[i], dp[j - 1]);
            }
        }
        System.out.println(dp[n]);
    }

    public static int solve(String str){
        int[] last = new int[]{-1, -1, -1};
        int n = str.length();
        if(n == 0) return 0;
        int[] dp = new int[n + 1];

        int sum = (str.charAt(0) - '0') % 3;
        last[sum] = 0;
        dp[0] = last[0] == 0 ? 1 : 0;
        for(int i = 1; i < n; i++){
            sum = (sum + str.charAt(i) - '0') % 3;
            int la = 0;
            if(last[sum] >= 0) la = dp[last[sum]];
            else if(sum == 0) la = 0;
            else la = -1;
            dp[i] = Math.max(dp[i - 1], la + 1);
            last[sum] = i;
        }
        return dp[n - 1];
    }
}

/*
С��ϲ�� 3 �ı��������֣�����С����һ������Ϊ n �����ִ���С����ͨ���ָ��ַ����ķ�ʽ�����һЩ�Ӵ���ÿ���Ӵ�����һ�����֣���ôС������ܻ�ö��ٸ������� 3 �ı����أ�

���磬С�������� 1123����ô���Էָ�Ϊ[1,12,3]��������������������� 3 �ı�����

��ע�⣬�ָ�������ִ������ܰ���ǰ���㣬���� 012 ������Ϊ 12�����Էָ�� 0��0 Ҳ�� 3 �ı�����

��������

��һ������һ��û��ǰ����������� n����ʾС������֡� 1\leq n \leq 10^{10^5}

�������

���һ����������ʾС���ܹ���õ� 3 �ı��������ֵ����������
 */