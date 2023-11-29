package oralTest.oppo1027;

import java.util.*;

public class Test03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ints = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = ints[0];
        int k = ints[1];
        String str = sc.nextLine();
        sc.close();
        if(n < 3 * k + 1) System.out.println(-1);
        int[][] dp = new int[n + 1][k + 1];
        int[][] min = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            Arrays.fill(min[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
            min[i][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if(i < 3 * j + 1){
                    dp[i][j] = Integer.MAX_VALUE;
                    continue;
                }
                int tt = 0;
                if(str.charAt(i - 1) != 'o') tt++;
                if(str.charAt(i - 2) != 'p') tt++;
                if(str.charAt(i - 3) != 'p') tt++;
                if(j == 1){
                    if(str.charAt(i - 4) != 'o') tt++;
                    dp[i][j] = dp[i - 4][j - 1] + tt;
                }
                else{
                    dp[i][j] = dp[i - 3][j - 1]  + tt;
                    if(str.charAt(i - 4) != 'o') tt++;
                    dp[i][j] = Math.min(min[i - 4][j - 1] + tt, dp[i][j]);
                }
                min[i][j] = Math.min(min[i - 1][j], dp[i][j]);
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 3 * k + 1; i <= n; i++){
            res = Math.min(res, dp[i][k]);
        }
        System.out.println(res);
    }
}

/*
Сŷ��һ������Сд��ĸ��ɵ��ַ�����Сŷÿ�ο����޸�һ����ĸ����ʹ���ַ�����������k���Ӵ��ǡ�oppo������С�޸Ĵ�����

��������

��һ�������������� n,k(1<=n<=10^4,1<=k<=200)

�ڶ�������һ������Ϊ n �Ľ���Сд��ĸ��ɵ��ַ�����

�������

���һ��������ʾ�𰸡�

�����޽������ -1��

˼·�ʹ���
ʹ�ö�̬�滮�ķ������������ڸ������������£�ͨ���滻�ַ�'o'Ϊ'p'��ʹ���ַ����е��ַ�'p'�������ֵ���С����������޷������㹻���滻�����������-1��
 */