package oralTest.wait_xiecheng0921;

import oralTest.InputUtils;

import java.util.HashMap;

public class Test02 {
    public boolean solve(String s, String t){
        int ls = s.length(), lt = t.length();
        HashMap<Character, Character> map = new HashMap<>();
        for(int i = 0; i < ls; i++){
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i)) != t.charAt(i)) return false;
            }
            else map.put(s.charAt(i), t.charAt(i));
        }
        return true;
    }
    public static void main(String[] args) {
        Test02 test02 = new Test02();
        int n = InputUtils.getLineAsInt();
        while (n-- > 0){
            String s = InputUtils.getLine();
            String t = InputUtils.getLine();
            System.out.println(test02.solve(s, t) ? "YES" : "NO");
        }
    }
}
