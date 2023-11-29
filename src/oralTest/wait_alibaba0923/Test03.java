package oralTest.wait_alibaba0923;

import oralTest.InputUtils;

import java.util.HashMap;
import java.util.HashSet;

public class Test03 {
    private int ans = 0;
    private HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
    private int[] arr;
    private int[] weight;
    private int[] near;
    private int[] preNear;

    public int solve() {
        int n = Integer.parseInt(InputUtils.getLine());
        arr = InputUtils.getArrayBySplit();
        weight = InputUtils.getArrayBySplit();
        near = new int[n + 1];
        preNear = new int[n + 1];
        for (int i = 0; i < n - 1; i++) {
            if (map.containsKey(arr[i])) {
                HashSet<Integer> set = map.get(arr[i]);
                set.add(i + 2);
            } else {
                HashSet<Integer> set = new HashSet<>();
                set.add(i + 2);
                map.put(arr[i], set);
            }
        }
        HashSet<Integer> has = new HashSet<>();
        has.add(weight[0]);
        near[1] = 1;
        bfs(1, has, 1);
        return ans + n;
    }

    private void bfs(int cur, HashSet<Integer> has, int depth) {
        if (!map.containsKey(cur)) {
            ans ++;
            return;
        }
        HashSet<Integer> outs = map.get(cur);
        for (Integer out : outs) {
            if (!has.contains(weight[out - 1])) {
                int temp = near[out];
                near[out] = depth;
                has.add(weight[out - 1]);
                ans =+ depth - temp;
                bfs(out, has, depth + 1);
                has.remove(weight[out - 1]);
                near[out] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Test03 test03 = new Test03();
        System.out.println(test03.solve());
    }
}
