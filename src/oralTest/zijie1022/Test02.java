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
��������������n��x��С��ϣ���㹹��һ������Ϊn�����飬���� �ƣ�n,i=1��sum(i) = x��

sum(i)�������ǰi��֮�͡�����֮��С��ϣ���㹹��һ������Ϊn���������㣬n��ǰ׺��֮�͵���t��

Ҫ�������Ԫ�ؽ���1��2��ɡ�
 */