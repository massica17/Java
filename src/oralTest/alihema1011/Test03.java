package oralTest.alihema1011;

import oralTest.InputUtils;

import java.util.HashMap;

public class Test03 {
    private int[] nw = new int[]{0, 1, 0, -1, 0};
    private int[] nh = new int[]{0, 0, 1, 0, -1};
    private int H;
    private int W;

    public int bfs(int h, int w, int cur, int time, HashMap<Integer, HashMap<Integer, HashMap<Integer, Integer>>> map, int maxTime) {
        if (map.containsKey(h)) {
            HashMap<Integer, HashMap<Integer, Integer>> map1 = map.get(h);
            if (map1.containsKey(w)) {
                HashMap<Integer, Integer> map2 = map1.get(w);
                if (map2.containsKey(time)) {
                    cur += map2.get(time);
                }
            }
        }
        if (time > maxTime) return cur;
        int max = 0;
        int th;
        int tw;
        for (int i = 0; i < 4; i++) {
            th = h + nh[i];
            tw = w + nw[i];
            if (th >= 1 && th <= H && tw >= 1 && tw <= W) {
                max = Math.max(max, bfs(th, tw, cur, time + 1, map, maxTime));
            }
        }
        return max;
    }

    public int solve() {
        int[] array = InputUtils.getArrayBySplit();
        int n = array[0];
        int m = array[1];
        int k = array[2];
        H = n;
        W = m;
        HashMap<Integer, HashMap<Integer, HashMap<Integer, Integer>>> map = new HashMap<>();
        int maxTime = 0;
        for (int i = 0; i < k; i++) {
            array = InputUtils.getArrayBySplit();
            int h = array[0];
            int w = array[1];
            int t = array[2];
            int s = array[3];
            maxTime = Math.max(maxTime, t);
            if (map.containsKey(h)) {
                HashMap<Integer, HashMap<Integer, Integer>> map1 = map.get(h);
                if (map1.containsKey(w)) {
                    HashMap<Integer, Integer> map2 = map1.get(w);
                    map2.put(t, map2.getOrDefault(t, 0) + s);
                } else {
                    HashMap<Integer, Integer> map2 = new HashMap<>();
                    map2.put(t, s);
                    map1.put(w, map2);
                }
            } else {
                HashMap<Integer, HashMap<Integer, Integer>> map1 = new HashMap<>();
                HashMap<Integer, Integer> map2 = new HashMap<>();
                map2.put(t, s);
                map1.put(w, map2);
                map.put(h, map1);
            }
        }
        return bfs(1, 1, 0, 0, map, maxTime);
    }

    public static void main(String[] args) {
        Test03 test03 = new Test03();
        System.out.println(test03.solve());
    }
}
