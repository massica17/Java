package oralTest.didi0915;

import oralTest.InputUtils;

public class Test02 {
    private int[][] map;
    private boolean[][] use;
    private int ans;
    private final int[] moveH = new int[]{0, 1, 0, -1};
    private final int[] moveW = new int[]{1, 0, -1, 0};
    public int solve(){
        ans = Integer.MAX_VALUE;
        int[] arr = InputUtils.getArrayBySplit();
        int n = arr[0];
        int m = arr[1];
        map = new int[n][m];
        use = new boolean[n][m];
        for(int i = 0; i < n; i++){
            map[i] = InputUtils.getArrayBySplit();
        }
        bfs(0, 0, n, m, 0);
        return ans;
    }

    public void bfs(int curH, int curW, int n, int m, int time){
        if(map[curH][curW] == 1) time++;
        if(curH == n - 1 && curW == m - 1){
            ans = Math.min(ans, time);
            return;
        }
        for(int i = 0; i < 4; i++){
            int nextH = curH + moveH[i];
            int nextW = curW + moveW[i];
            if (nextH >= 0 && nextH < n && nextW >= 0 &&  nextW < m && !use[nextH][nextW]) {
                use[nextH][nextW] = true;
                bfs(nextH, nextW, n, m, time);
                use[nextH][nextW] = false;
            }
        }
    }
    public static void main(String[] args) {
        Test02 test02 = new Test02();
        System.out.println(test02.solve());
    }
}
