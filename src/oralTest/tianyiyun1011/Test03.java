package oralTest.tianyiyun1011;

import oralTest.InputUtils;

import java.util.Deque;
import java.util.LinkedList;

public class Test03 {
    public int solve() {
        String str = InputUtils.getLine();
        int ls = str.length();
        if (ls <= 1) return 0;
        int start = 0;
        int end = ls - 1;
        int ans = 0;
        while (start < end && str.charAt(start) == str.charAt(end)) {
            start++;
            end--;
            ans += 2;
        }
        if(start < end){
            Deque<Character> deque = new LinkedList<>();
            for(int i = start; i <= end; i++){
                if(!deque.isEmpty() && deque.peekLast() == str.charAt(i)){
                    ans += 2;
                    deque.pollLast();
                }
                else{
                    deque.addLast(str.charAt(i));
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Test03().solve());
    }
}
