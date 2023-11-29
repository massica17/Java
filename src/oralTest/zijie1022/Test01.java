package oralTest.zijie1022;

import java.util.Arrays;
import java.util.Scanner;

public class Test01 {
    public static void bfs(int[] nums, int[] time, int start) {
        Arrays.fill(time, Integer.MAX_VALUE);
        int count = 0;
        while (time[start] == Integer.MAX_VALUE) {
            time[start] = count;
            start = nums[start];
            count++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int t = scanner.nextInt();
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) nums[i] = scanner.nextInt();
        scanner.close();
        int[] sTime = new int[n + 1];
        int[] tTime = new int[n + 1];
        bfs(nums, sTime, s);
        bfs(nums, tTime, t);
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            ans = Math.min(ans, Math.max(sTime[i], tTime[i]));
        }
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}
/*
小红和朋友被困在了迷宫里，迷宫有n 个传送阵，每个传送阵都有一个编号i(编号从1到n)，编号为i的传送阵会将小红传送到编号为ai的传送阵。小红最初在编号为s的传送阵，朋友最初在编号为t的传送阵，小红和朋友都可以通过传送阵传送，每次传送都会花费一分钟(两人可以同时传送)。现在小红想知道，小红和朋友最少需要多少分钟才能在同一个传送阵里见面，如果不能见面，输出 -1。
 */

/*
该程序的核心思想是通过使用广度优先搜索（BFS）算法，计算从给定起点 s 和终点 t 到图中所有其他节点的最短距离。首先，将输入的节点信息存储在向量中，并初始化两个向量 S 和 T，用于分别记录从 s 和 t 到各个节点的距离，初始值为无穷大（INT_MAX）。然后，通过两次BFS遍历计算出从 s 和 t 到每个节点的最短距离，并将结果存储在 S 和 T 向量中。接下来，程序找到从 s 和 t 到每个节点的最短距离之间的最大值，找到最小值，这将是从 s 和 t 到达某个节点的最短路径。最后，程序输出这个最小值作为答案，如果无法从 s 和 t 到达任何节点，则输出 -1。这个核心思想允许解决一种特定问题，即从起点 s 和终点 t 出发，寻找最短路径，并输出其长度。
 */