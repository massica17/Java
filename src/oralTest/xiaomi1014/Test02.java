package oralTest.xiaomi1014;

import oralTest.InputUtils;

import java.util.Arrays;

public class Test02 {
    public int solve(){
        String[] strings = InputUtils.getStringArrayBySplitByComma();
        int[] version1 = Arrays.stream(strings[0].split("\\.")).mapToInt(Integer::valueOf).toArray();
        int[] version2 = Arrays.stream(strings[0].split("\\.")).mapToInt(Integer::valueOf).toArray();
        int n1 = version1.length;
        int n2 = version2.length;
        int n = Math.min(n1, n2);
        for(int i = 0; i < n; i++){
            if(version1[i] == version2[i]) continue;
            if (version1[i] > version2[i]) {
                return 1;
            }
            else return -1;
        }
        if(n1 > n2) for(int i = n2; i < n1; i++) if(version1[i] != 0) return -1;
        if(n2 > n1) for(int i = n1; i < n2; i++) if(version2[i] != 0) return 1;
        return 0;
    }
    public static void main(String[] args) {
        Test02 test02 = new Test02();
        System.out.println(test02.solve());
    }
}
