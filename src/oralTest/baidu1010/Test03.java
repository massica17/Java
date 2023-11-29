package oralTest.baidu1010;

import oralTest.InputUtils;

public class Test03 {
    private int[] father;
    private int[] size;
    private long mod = (long) (7 + 1e9);
    private int findParent(int x){
        int r = x;
        if(r == father[r]) return r;
        return father[r] = findParent(father[r]);
    }

    private void union(int i, int j){
        int fi = findParent(i);
        int fj = findParent(j);
        if(fi == fj){
            father[fi] = fj;
            size[fi] += size[fj];
        }
    }

    private long modPow(int a, int b){
        if(b == 0) return 1;
        long res = modPow(a, b / 2);
        res *= res;
        res %= mod;
        if(b % 2 == 1){
            res *= a;
            res %= mod;
        }
        return res;
    }
    public int solve(){
        int[] array = InputUtils.getArrayBySplit();
        int n = array[0];
        int k = array[1];
        father = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++){
            father[i] = 1;
            size[i] = 1;
        }
        int u, v, w;
        for(int i = 0; i < n - 1; i++){
            array = InputUtils.getArrayBySplit();
            u = array[0] - 1;
            v = array[1] - 1;
            w = array[2];
            if(w == 0){
                union(u, v);
            }
        }
        long tot = modPow(n, k);
        for(int i = 0; i < n; i++){
            if(father[i] == i){
                long res = modPow(size[i], k);
                tot = (tot - res + mod) % mod;
            }
        }
        return (int) tot;
    }
    public static void main(String[] args) {

    }
}
