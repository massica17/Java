package oralTest.baidu1010;

import oralTest.InputUtils;

public class Test01 {
    public int solve(){
        int[] array = InputUtils.getArrayBySplit();
        int n = array[0], m = array[1], k = array[2];
        int[] room = new int[m + 1];
        for(int i = 0; i < n; i++){
            array = InputUtils.getArrayBySplit();
            int mi = array[0], ai = array[1];
            if(room[mi] == 0) room[mi] = ai;
            else room[mi] = Math.min(ai, room[mi]);
        }
        int ans = 0;
        for(int i = 1; i <= m; i++){
            ans += room[i];
        }
        return Math.min(ans, k);
    }
    public static void main(String[] args) {
        System.out.println(new Test01().solve());
    }
}
