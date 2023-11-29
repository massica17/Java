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
小红拿到了一个仅由小写字母组成的字符串s,她希望你构造一个字符串t，满足以下条件：

1.也是仅由小写字母组成，长度和s相同。

2.t是回文串。

3.的字典序小于s，且在满足以上条件时字典序尽可能大。

输入描述：

一个字符串s,字符串长度不超过100000。

输出描述：

如果无解，则输出-1。否则输出一个字符串t。

思路与代码

根据题意，先去除len(s)/2个字符，用他来构造回文串t，看t和s的大小关系，如果不满足则在前len(s)/2字符内贪心的找到最后一个不为'a'的字符（假设位置idx），将它的字符值-1，并且让(idx,len(s)/2]位置的值都置为z即可。
 */