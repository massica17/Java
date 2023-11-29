package oralTest.liantong1028;

public class Test02 {
    public int getWays(int n){
        if(n <= 2) return n;
        return getWays(n - 1) + getWays(n - 2);
    }

    public static void main(String[] args) {
        Test02 test02 = new Test02();
        System.out.println(test02.getWays(4));
    }
}
