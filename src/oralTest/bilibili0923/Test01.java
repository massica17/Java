package oralTest.bilibili0923;

import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.List;

public class Test01 {

    public String check1(String str, int num){
        int ls = str.length();
        int cnt = 0;
        List<Integer> idx = new ArrayList<>();
        if((num & 1)  > 0 || ((num & (1 << (ls - 1))) > 0)) return "";
        for(int i = 0; i < ls; i++){
            if((num & (1 << i)) != 0){
                cnt++;
                idx.add(i);
            }
        }
        if(cnt != 3) return "";
        int n1 = Integer.parseInt(str.substring(0, idx.get(0)));
        int n2 = Integer.parseInt(str.substring(idx.get(0), idx.get(1)));
        int n3 = Integer.parseInt(str.substring(idx.get(1), idx.get(2)));
        int n4 = Integer.parseInt(str.substring(idx.get(2), ls));
        String sb = String.valueOf(n1) + '.' + n2 + '.' + n3 + '.' + n4;
        return check2(n1) && check2(n2) && check2(n3) && check2(n4) ? sb : "";
    }

    public boolean check2(int n){
        return n <= 255 && n >= 0;
    }
    public List<String> solve(String str) {
        int ls = str.length();
        int n = 1 << ls;
        List<String> res = new ArrayList<>();
        if(ls < 4) return res;
        for (int i = 0; i < n; i++) {
            String s = check1(str, i);
            if(s.length() > 0) res.add(s);
        }
        return res;
    }
    public static void main(String[] args) {
        Test01 test01 = new Test01();
        System.out.println(test01.solve("25525511135"));
    }
}
