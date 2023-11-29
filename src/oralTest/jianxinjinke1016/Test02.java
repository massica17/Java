package oralTest.jianxinjinke1016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Test02 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine().trim();
        bufferedReader.close();
        int[] cnt = new int[26];
        int ls = s.length();
        for (int i = 0; i < ls; i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        Arrays.sort(cnt);
        int ans = 0;
        int start = 0;
        while(cnt[start] == 0) start ++;
        for(int i = ls - 2; i >= start; i--){
            if(cnt[i] >= cnt[i + 1]){
                ans += (cnt[i] - (cnt[i + 1] - 1));
                cnt[i] = cnt[i + 1] - 1;
            }
        }
        System.out.println(ans);
    }
}
