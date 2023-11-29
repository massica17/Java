package oralTest.tianyiyun1011;

import oralTest.InputUtils;

public class Test02 {
    public boolean solve() {
        int[] array = InputUtils.getArrayBySplitByComma();
        int[] hash = new int[122 - 97 + 1];
        int n = array.length;
        for (int j : array) {
            hash[j - 97]++;
        }
        String res = "dianxin";
        int ls = res.length();
        for(int i = 0; i < ls; i++){
            if(hash[res.charAt(i) - 'a'] == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(new Test02().solve() ? 1 : 0);
    }
}
