package oralTest.zijie1015;

import oralTest.InputUtils;

import java.util.Map;
import java.util.PriorityQueue;

public class Test04 {
    public static void main(String[] args) {
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();
        String[] strings = InputUtils.getStringArrayBySplit();
        int n = Integer.parseInt(strings[0]);
        double p = Double.parseDouble(strings[1]);
        int[] nums = InputUtils.getArrayBySplit();
        int cur;
        int ansMax = Integer.MAX_VALUE;
        for(int i = n - 1; i >= 0; i--){
            cur = (int) Math.ceil(p * (double)(n - i));
            if(rightHeap.size() == 0){
                rightHeap.add(nums[i]);
            }
            else{
                if (nums[i] < rightHeap.peek()) {
                    leftHeap.add(nums[i]);
                }
                else{
                    rightHeap.add(nums[i]);
                }
                while (rightHeap.size() < cur){
                    rightHeap.add(leftHeap.poll());
                }
                while (rightHeap.size() - 1 >= cur){
                    leftHeap.add(rightHeap.poll());
                }
            }
            if(!rightHeap.isEmpty())ansMax = Math.min(ansMax, rightHeap.peek());
        }
        System.out.println(ansMax);
    }
}
