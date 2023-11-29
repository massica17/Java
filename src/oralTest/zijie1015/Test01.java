package oralTest.zijie1015;


import oralTest.InputUtils;

import java.io.IOException;

public class Test01 {
    public static int getMaxLen(char[] chars, char left_char, char right_char, int left_idx){
        int right_idx = left_idx + 1;
        int max_len = 0;
        while(chars[left_idx] == left_char && chars[right_idx] == right_char){
            left_idx--;
            right_idx--;
            max_len += 2;
        }
        return max_len;
    }
    public static void main(String[] args) throws IOException {
        String line = InputUtils.getLine();
        int ls = line.length();
        char[] chars = line.toCharArray();
        char cur = chars[0];
        int curCnt = 1;
        int notCur = 0;
        int ans = 0;
        for(int i = 1; i < ls; i++){
            if(chars[i] == cur){
                curCnt ++;
            }
            else{
                notCur = curCnt;
                curCnt = 1;
                cur = chars[i];
            }
            //System.out.printf("cur %c curCnt %d notCur %d %n", cur, curCnt, notCur);
            ans = Math.max(2 * Math.min(curCnt, notCur), ans);
        }
        System.out.println(ans);
    }
}
