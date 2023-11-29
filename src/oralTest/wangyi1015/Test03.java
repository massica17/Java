package oralTest.wangyi1015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test03 {
    private int[] father;

    public static void main(String[] args) throws IOException {
        Object strt = new String("asdf");
        System.out.println(strt);
        Test03 test03 = new Test03();
        System.out.println(test03.solve());
    }

    public int solve() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        father = new int[n];
        for (int i = 0; i < n; i++) father[i] = i;

        int[] first = new int[m + 1];
        Arrays.fill(first, -1);


        for (int i = 0; i < n; i++) {
            int cnt = scanner.nextInt();
            while(cnt-- > 0){
                int lang = scanner.nextInt();
                if(first[lang] == -1) first[lang] = i;
                else{
                    connect(i, first[lang], father);
                }
            }
        }
        boolean has = false;
        for(int i = 1; i <= m; i++){
            if(first[i] != -1) has = true;
        }
        if(!has){
            return n;
        }
        int ans = 0;
        for(int i = 0; i < n; i++) {
            if(findFather(i, father) == i){
                ans++;
            }
        }
        return ans - 1;
    }

    public int findFather(int i, int[] f){
        if(f[i] == i) return i;
        return f[i] = findFather(f[i], f);
    }

    public void connect(int i, int j, int[] f){
        int fi = findFather(i, f);
        int fj = findFather(j, f);
        if(fi != fj){
            f[fi] = fj;
        }
    }
}
