package oralTest.zijie1015;

import oralTest.InputUtils;
import oralTest.Main;

import java.util.Arrays;

public class Test02 {
    public static void main(String[] args) {
        int[] array = InputUtils.getArrayBySplit();
        int n = array[0];
        int p = array[1];
        int[] an = InputUtils.getArrayBySplit();
        int[] bn = InputUtils.getArrayBySplit();
        for(int i = 0; i < n; i++){
            an[i] = an[i] - p;
            bn[i] = bn[i] - p;
        }
        Arrays.sort(an);
        Arrays.sort(bn);
        int ans = 0;
        for(int i = 0; i < n; i++){
            ans += Math.abs(an[i] - bn[i]) + Math.abs(bn[i]);
        }
        System.out.println(ans);
    }
}
