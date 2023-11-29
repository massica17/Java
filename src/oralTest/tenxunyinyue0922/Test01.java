package oralTest.tenxunyinyue0922;

import oralTest.InputUtils;

public class Test01 {
    public int solve1(int n){
        int cnt = 0;
        while(n % 5 != 0){
            cnt ++;
            n /= 10;
        }
        return cnt;
    }
    public static void main(String[] args) {
        Test01 test01 = new Test01();
        System.out.println(test01.solve1(InputUtils.getLineAsInt()));
    }
}
