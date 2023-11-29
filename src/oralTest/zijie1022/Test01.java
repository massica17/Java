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
С������ѱ��������Թ���Թ���n ��������ÿ����������һ�����i(��Ŵ�1��n)�����Ϊi�Ĵ�����ὫС�촫�͵����Ϊai�Ĵ�����С������ڱ��Ϊs�Ĵ�������������ڱ��Ϊt�Ĵ�����С������Ѷ�����ͨ���������ͣ�ÿ�δ��Ͷ��Ứ��һ����(���˿���ͬʱ����)������С����֪����С�������������Ҫ���ٷ��Ӳ�����ͬһ������������棬������ܼ��棬��� -1��
 */

/*
�ó���ĺ���˼����ͨ��ʹ�ù������������BFS���㷨������Ӹ������ s ���յ� t ��ͼ�����������ڵ����̾��롣���ȣ�������Ľڵ���Ϣ�洢�������У�����ʼ���������� S �� T�����ڷֱ��¼�� s �� t �������ڵ�ľ��룬��ʼֵΪ�����INT_MAX����Ȼ��ͨ������BFS����������� s �� t ��ÿ���ڵ����̾��룬��������洢�� S �� T �����С��������������ҵ��� s �� t ��ÿ���ڵ����̾���֮������ֵ���ҵ���Сֵ���⽫�Ǵ� s �� t ����ĳ���ڵ�����·������󣬳�����������Сֵ��Ϊ�𰸣�����޷��� s �� t �����κνڵ㣬����� -1���������˼��������һ���ض����⣬������� s ���յ� t ������Ѱ�����·����������䳤�ȡ�
 */