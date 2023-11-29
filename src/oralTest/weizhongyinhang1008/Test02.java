package oralTest.weizhongyinhang1008;

import oralTest.InputUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Test02 {
    public int solve() {
        int[] arr = InputUtils.getArrayBySplit();
        int n = arr[0], m = arr[1], r = arr[2];
        char[][] map = new char[n][m];
        char[][] copyMap = new char[n][m];
        for (int i = 0; i < n; i++) {
            String temp = InputUtils.getLine();
            map[i] = temp.toCharArray();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == '1') {
                    changeMap(copyMap, i, j, r, '1');
                } else if (map[i][j] == '2') {
                    changeMap(copyMap, i, j, r, '2');
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (copyMap[i][j] == '2') {
                    ans++;
                }
            }
        }
        return ans;
    }

    public void changeMap(char[][] map, int ht, int wt, int r, char num) {
        int n = map.length, m = map[0].length;
        for (int i = ht - r; i <= ht + r; i++) {
            for (int j = wt - r; j <= wt + r; j++) {
                if (i >= 0 && i < n && j >= 0 && j < m) {
                    if ((ht - i) * (ht - i) + (wt - j) * (wt - j) <= r * r) {
                        if (map[i][j] != '1') {
                            map[i][j] = num;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Test02 test02 = new Test02();
        System.out.println(test02.solve());
    }
}
