package oralTest.weizhongyinhang1008;

import oralTest.InputUtils;

import java.util.Arrays;

public class Test01 {
    private int minPrice = Integer.MAX_VALUE;

    public int solve() {
        minPrice = Integer.MAX_VALUE;
        int[] arr = InputUtils.getArrayBySplit();
        int n = arr[0], m = arr[1];
        arr = InputUtils.getArrayBySplit();
        int a = arr[0], b = arr[1];
        arr = InputUtils.getArrayBySplit();
        int c = arr[0], d = arr[1];
        int[][] map = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) Arrays.fill(map[i], Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            arr = InputUtils.getArrayBySplit();
            map[arr[0]][arr[1]] = arr[2];
            map[arr[1]][arr[0]] = arr[2];
        }
        map[c][d] = 0;
        map[d][c] = 0;
        boolean[] use = new boolean[n + 1];
        bfs(map, use, a, b, 0);
        return minPrice;
    }

    private void bfs(int[][] map, boolean[] use, int cur, int end, int price) {
        if (cur == end) {
            minPrice = Math.min(minPrice, price);
            return;
        }
        for (int i = 1; i < map[cur].length; i++) {
            if (!use[i] && map[cur][i] != Integer.MAX_VALUE) {
                use[i] = true;
                bfs(map, use, i, end, price + map[cur][i]);
                use[i] = false;
            }
        }
    }
    public void floyd(int[][] map, int a, int b){
        int n = map.length;
        int[][] dis = new int[n + 1][n + 1];
        for(int i = 0; i <= n; i++) {
            dis[i] = Arrays.copyOf(map[i], map[i].length);
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                for(int k = 1; k <= n; k++){
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                }
            }
        }
        System.out.println(dis[a][b]);
    }
}
