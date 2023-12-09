package oralTest.zijie0917;

import oralTest.InputUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;

public class Test01 {
    private HashMap<Long, Integer> map = new HashMap<>();
    long getHash(String str){
        int ls = str.length();
        long res = 0;
        for(int i = 0; i < ls; i++){
            res *= 100;
            res += (str.charAt(i) - 'a' + 1);
        }
        return res;
    }
    public void getMap(String s){
        int ls = s.length();
        for(int i = 0; i < ls; i++){
            long cur = 0;
            for(int j = 0; j < 10; j++){
                if(i + j >= ls) break;
                cur *= 100;
                cur += (s.charAt(i + j) - 'a' + 1);
                map.put(cur, map.getOrDefault(cur, 0) + 1);
            }
        }
    }

    public int solve(String q){
        long hash = getHash(q);
        return map.getOrDefault(hash, 0);
    }
    public static void main(String[] args) {
        int[] ints = InputUtils.getArrayBySplit();
        int n = ints[0];
        int q = ints[1];
        Test01 test01 = new Test01();
        String s = InputUtils.getLine();
        test01.getMap(s);
        while (q-- > 0){
            System.out.println(test01.solve(InputUtils.getLine()));
        }
    }
}
