package oralTest.jibite1025;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Test03 {
    public static int cnt = 0;

    public static void main(String[] args) {
        cnt = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();
        int[] state = new int[n + 1];
        int[][] map = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int ht = sc.nextInt();
            int wt = sc.nextInt();
            map[ht][wt] = 1;
            map[wt][ht] = 1;
        }
        state[1] = 2;
        bfs(map, state, 1);
        while(t-- > 0) {
            int a = sc.nextInt();
            if(state[a] == 0) state[a] = 1;
            for(int i = 1; i < map.length; i++){
                if(state[i] == 2 && (map[i][a] == 1 || map[a][i] == 1)) {
                    state[a] = 2;
                    break;
                }
            }
            bfs(map, state, a);
            System.out.println(Arrays.stream(state).filter(o1 -> o1 == 2).count());
        }

    }

    public static void bfs(int[][] map, int[] state, int x) {
        for (int i = 1; i < map.length; i++) {
            if (state[i] == 1 && x != i) {
                if (map[x][i] == 1 || map[i][x] == 1) {
                    state[i] = 2;
                    bfs(map, state, i);
                }
            }
        }
    }
}
