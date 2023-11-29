package oralTest.jingdong0928;

import oralTest.InputUtils;

public class Test03 {
    public void solve() {
        int[] array = InputUtils.getArrayBySplit();
        double x = array[0];
        double y = array[1];
        double a = 1, b = -2 * (x + y), c = x * x + y * y;
        double sqrt = Math.sqrt(b * b - 4 * a * c);
        double r1 = (-b - sqrt) / 2 * a;
        double r2 = (-b + sqrt) / 2 * a;
        System.out.printf("%.6f %.6f%n", r1, r2);
    }

    public static void main(String[] args) {
        Test03 test03 = new Test03();
        test03.solve();
    }
}
