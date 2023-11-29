package oralTest.alifeizhu1028;

import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        sc.close();
        int ls = str.length();
        char[] t = new char[ls];
        for (int i = 0; i <= (ls - 1) / 2; i++) t[i] = str.charAt(i);
        int up = (ls - 1) / 2;
        if (ls % 2 == 1) up--;
        int cur = up + 1;
        for (int i = up; i >= 0; i--) {
            t[cur] = str.charAt(i);
            cur++;
        }
        if (String.valueOf(t, 0, (ls - 1) / 2 + 1).compareTo(str) >= 0) {
            int idx = (ls - 1) / 2;
            while (idx >= 0 && str.charAt(idx) == 'a') {
                t[idx] = 'z';
                idx--;
            }
            if (idx < 0) {
                System.out.println("-1");
            } else {
                t[idx]--;
                for (int i = (ls - 1) / 2 + 1; i < ls; i++) {
                    t[i] = t[ls - i - 1];
                }
                System.out.println(String.valueOf(t));
            }
        }
    }
}

/*
С���õ���һ������Сд��ĸ��ɵ��ַ���s,��ϣ���㹹��һ���ַ���t����������������

1.Ҳ�ǽ���Сд��ĸ��ɣ����Ⱥ�s��ͬ��

2.t�ǻ��Ĵ���

3.���ֵ���С��s������������������ʱ�ֵ��򾡿��ܴ�

����������

һ���ַ���s,�ַ������Ȳ�����100000��

���������

����޽⣬�����-1���������һ���ַ���t��

˼·�����

�������⣬��ȥ��len(s)/2���ַ���������������Ĵ�t����t��s�Ĵ�С��ϵ���������������ǰlen(s)/2�ַ���̰�ĵ��ҵ����һ����Ϊ'a'���ַ�������λ��idx�����������ַ�ֵ-1��������(idx,len(s)/2]λ�õ�ֵ����Ϊz���ɡ�
 */