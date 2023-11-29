package oralTest.xinhuasan1013;

import oralTest.InputUtils;

import java.util.ArrayList;
import java.util.List;

public class Test01 {
    public static boolean isPrime(int n) {
        if (n < 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> solve(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 2; i <= n; i++){
            if(isPrime(i)){
                res.add(i);
            }
        }
        return res;
    }
}
