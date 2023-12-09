package oralTest.wait_huawei0920;

import oralTest.InputUtils;

import java.security.PublicKey;

public class Test02 {
    private int[] moveH = new int[]{0, 1, 0, -1};
    private int[] moveW = new int[]{1, 0, -1, 0};
    private int ans = Integer.MAX_VALUE;
    public int solve(int n, int m, int[][] map){
        ans = Integer.MAX_VALUE;
        if(n == 0 || m == 0) return 0;
        boolean[][] use = new boolean[n][m];
        for(int i = 0; i < n; i++){
            if(map[i][0] == 1){
                bfs(i, 0, map, use, 0);
            }
        }
        return ans;
    }
    public void bfs(int cur_h, int cur_w, int[][] map, boolean[][] use, int cur){
        if(cur_w == map[0].length - 1 && map[cur_h][cur_w] == 1) {
            ans = Math.min(ans, cur);
            return;
        }
        int th, tw;
        int n = map.length;
        int m = map[0].length;
        for(int i = 0; i < 4; i++){
            th = cur_h + moveH[i];
            tw = cur_w + moveW[i];
            if(th < n && th >= 0 && tw < m && tw >= 0 && !use[th][tw]){
                use[th][tw] = true;
                bfs(th, tw, map, use, cur + 1);
                use[th][tw] = false;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = InputUtils.getArrayBySplit();
        int n = arr[0];
        int m = arr[1];
        int[][] map = new int[n][m];
        for(int i = 0; i < n; i++) map[i] = InputUtils.getArrayBySplit();
        Test02 test02 = new Test02();
        System.out.println(test02.solve(n, m, map));
    }
}
