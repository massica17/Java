package oralTest.weizhongyinhang0913;

import oralTest.InputUtils;

import java.util.Arrays;

public class Test03 {
    private int[] father;
    private int[] rank;

    public void solve() {
        int[] arr = InputUtils.getArrayBySplit();
        int n = arr[0], m = arr[1], s = arr[2], t = arr[3];
        father = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            father[i] = i;
            rank[i] = 1;
        }
        for (int i = 0; i < m; i++) {
            arr = InputUtils.getArrayBySplit();
            int u = arr[0], v = arr[1];
            int uf = find(u);
            int vf = find(v);
            union(uf, vf);
        }
        int s_fa = find(s);
        int t_fa = find(t);
        if (s_fa == t_fa) {
            System.out.println(n * (n - 1) / 2);
        } else {
            int cnt_s = 0, cnt_t = 0;
            for (int i = 1; i <= n; i++) {
                int temp = find(i);
                if (temp == s_fa) {
                    cnt_s++;
                } else if (temp == t_fa) {
                    cnt_t++;
                }
            }
            System.out.println(cnt_s * cnt_t);
        }
    }

    public int find(int x) {
        return father[x] == x ? x : (father[x] = find(father[x]));
    }

    public void union(int i, int j) {
        int i_fa = find(i);
        int j_fa = find(j);
        if (rank[i] <= rank[j]) {
            father[i_fa] = j_fa;
        } else father[j_fa] = i_fa;
        if (rank[i_fa] == rank[j_fa] && i_fa != j_fa) rank[j_fa]++;
    }

    public static void main(String[] args) {
        Test03 test03 = new Test03();
        test03.solve();
    }
}
