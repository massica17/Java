package oralTest.huawei0913;

import oralTest.InputUtils;

public class Test03 {
    public void solve() {
        int n = InputUtils.getLineAsInt();
        int[][] pair = new int[n][2];
        int max_h = 0, max_w = 0;
        for (int i = 0; i < n; i++) {
            pair[i] = InputUtils.getArrayBySplit();
            max_h = Math.max(pair[i][0], max_h);
            max_w = Math.max(pair[i][1], max_w);
        }
        max_h += 3;
        max_w += 3;
        max_h = Math.min(max_h, 10000);
        max_w = Math.min(max_w, 10000);
        int[][] map = new int[max_h + 1][max_w + 1];
        for (int i = 0; i < n; i++) {
            for (int ht = pair[i][0] - 1; ht <= pair[i][0] + 1; ht++) {
                for (int wt = pair[i][1] - 1; wt <= pair[i][1] + 1; wt++) {
                    if (ht >= 1 && ht <= max_h && wt <= max_w && wt >= 1) {
                        map[ht][wt]++;
                    }
                }
            }
        }

        int ans = 0;
        int area = 0;
        for (int i = 0; i < n; i++) {
            boolean yes = true;
            for (int ht = pair[i][0] - 1; ht <= pair[i][0] + 1; ht++) {
                for (int wt = pair[i][1] - 1; wt <= pair[i][1] + 1; wt++) {
                    if (ht >= 1 && ht <= max_h && wt <= max_w && wt >= 1) {
                        if (map[ht][wt] == 1) yes = false;
                    }
                }
            }
            if (yes) ans++;
        }

        for(int i = 1; i <= max_h; i++){
            for(int j = 1; j <= max_w; j++){
                if(map[i][j] != 0) area ++;
            }
        }
        System.out.printf("%d %d%n", n - ans, area);
    }

    public static void main(String[] args) {
        Test03 test03 = new Test03();
        test03.solve();
    }
}
