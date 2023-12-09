package oralTest.weizhongyinhang0913;

import oralTest.InputUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Test01 {
    public void solve(int n, int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            if (!set.contains(arr[i])) {
                set.add(arr[i]);
                ans.add(arr[i]);
            }
        }
        int size = ans.size();
        System.out.printf("%d", ans.get(size - 1));
        for (int i = size - 2; i >= 0; i--) {
            System.out.printf(" %d", ans.get(i));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = InputUtils.getLineAsInt();
        int[] arr = InputUtils.getArrayBySplit();
        Test01 test01 = new Test01();
        test01.solve(n, arr);
    }
}
