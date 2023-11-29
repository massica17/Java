package oralTest.jianxinjinke1016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine().trim();
        bufferedReader.close();
        s = s.toLowerCase();
        int ls = s.length();
        int[] cnt = new int[4];
        for(int i = 0; i < ls; i++){
            char c = s.charAt(i);
            if(c == 'c'){
                cnt[0]++;
            }
            else if(c == 'b'){
                cnt[1]++;
            }
            else if(c == 'f'){
                cnt[2]++;
            }
            else if(c == 't'){
                cnt[3]++;
            }
        }
        cnt[0] /= 2;
        System.out.println(Arrays.stream(cnt).min().getAsInt());
    }
}
