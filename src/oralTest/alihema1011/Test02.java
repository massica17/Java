package oralTest.alihema1011;

import oralTest.InputUtils;

public class Test02 {
    public int solve(){
        int[] array = InputUtils.getArrayBySplit();
        int n = array[0];
        int m = array[1];
        int a = array[2];
        int b = array[3];
        int whole = n / m;
        int leave = n % m;
        return whole * Math.min(a, b * m) + Math.min(leave * b, a) + n;
    }
    public static void main(String[] args) {
        Test02 test02 = new Test02();
        System.out.println(test02.solve());
    }
}
