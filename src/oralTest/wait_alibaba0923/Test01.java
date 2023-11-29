package oralTest.wait_alibaba0923;

import oralTest.InputUtils;

public class Test01 {
    private int cnt = 0;

    public int solve(int[] nums) {
        cnt =  0;
        int[][] way = new int[][]{{1, 2, 4}, {1, 3, 6}, {1, 2, 6}};
        int[] hash = new int[7];
        for (int a : nums) {
            hash[a]++;
        }
        bfs(hash, way, cnt);
        return cnt;
    }

    private void bfs(int[] hash, int[][] way, int cnt) {
        if(cnt > this.cnt) this.cnt = cnt;
        for (int i = 0; i < 3; i++) {
            int x = way[i][0], y = way[i][1], z = way[i][2];
            if (hash[x] > 0 && hash[y] > 0 && hash[z] > 0) {
                hash[x]--;
                hash[y]--;
                hash[z]--;
                bfs(hash, way, cnt + 1);
                hash[x] ++;
                hash[y] ++;
                hash[z] ++;
            }
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(InputUtils.getLine());
        int[] array = InputUtils.getArrayBySplit();
        Test01 test01 = new Test01();
        System.out.println(test01.solve(array));
    }
}
