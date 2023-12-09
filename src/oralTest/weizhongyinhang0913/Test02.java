package oralTest.weizhongyinhang0913;

import oralTest.InputUtils;

import java.util.Deque;
import java.util.LinkedList;

public class Test02 {
    public void solve(int n, int[] arr) {
        Deque<Integer> deque = new LinkedList<>();
        for (int a : arr) {
            deque.addLast(a);
        }
        int cnt = 0;
        while (!deque.isEmpty()) {
            int head = deque.pollFirst();
            if (cnt == 0) System.out.printf("%d", head);
            else System.out.printf(" %d", head);
            cnt++;
            if(!deque.isEmpty()){
                deque.addLast(deque.pollFirst());
            }
        }
    }

    public static void main(String[] args) {
        Test02 test02 = new Test02();
        int n = InputUtils.getLineAsInt();
        int[] arr = InputUtils.getArrayBySplit();
        test02.solve(n, arr);
    }
}
