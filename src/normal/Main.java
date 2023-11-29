package normal;

import java.util.*;

class Solution {
    public int getNum(List<Integer> nums, List<Character> ops, int start, int cnt) {
        int res = nums.get(start);
        int temp = 1;
        while (temp < cnt) {
            char op = ops.get(start + temp - 1);
            if (op == '-') {
                res -= nums.get(start + temp);
            } else if (op == '+') {
                res -= nums.get(start + temp);
            } else if (op == '*') {
                res *= nums.get(start + temp);
            }
            temp++;
        }
        return res;
    }

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> nums = new ArrayList<>();
        List<Character> ops = new ArrayList<>();
        int ls = expression.length();
        int idx = 0;
        char c;
        while (idx < ls) {
            c = expression.charAt(idx);
            if (c == '+' || c == '-' || c == '*') {
                ops.add(c);
                idx++;
            } else {
                int n = 0;
                while (idx < ls && !((c = expression.charAt(idx)) == '+' || c == '-' || c == '*')) {
                    n *= 10;
                    n += c - '0';
                    idx++;
                }
                nums.add(n);
            }
        }
        int size = nums.size();
        int[][] dp = new int[size - 1][size - 1];
        for (int i = 2; i <= size; i++) {
            for (int j = 0; j + i - 1 < size; j++) {
                dp[i - 2][j] = getNum(nums, ops, j, i);
            }
        }
        return nums;
    }
}

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.diffWaysToCompute("2*3-4*5"));
    }
}
