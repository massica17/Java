package oralTest.yuewen1103;

public class Test02 {
    public int maxLen(int[] nums) {
        int n = nums.length;
        int[] maxPositive = new int[n + 1];
        int[] maxNegative = new int[n + 1];
        int ansMax = 0;
        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] > 0) {
                maxPositive[i] = maxPositive[i - 1] + 1;
                if (maxNegative[i - 1] > 0) maxNegative[i] = maxNegative[i - 1] + 1;
                else maxNegative[i] = maxNegative[i - 1];
            } else if (nums[i - 1] < 0) {
                if (maxNegative[i - 1] > 0) maxPositive[i] = maxNegative[i - 1] + 1;
                else maxPositive[i] = 0;
                maxNegative[i] = maxPositive[i - 1] + 1;
            } else {
                maxNegative[i] = 0;
                maxNegative[i] = 0;
            }
            ansMax = Math.max(ansMax, maxPositive[i]);
        }
        return ansMax;
    }

    public static void main(String[] args) {
        Test02 test02 = new Test02();
        test02.maxLen(new int[]{1, 2, 3, -1, 4});
    }
}

/*
给定一个长度为n的整数数组，请你找出其中最长的乘积为正数的子数组长度。子数组的定义是原数组中一定长度的连续数字组成的数组。

数据范围：1<n≤10^5，数组中的元素满足|val|≤10°≤10^9

示例1

输入

[1,2,3,-1,4]

输出

3

示例2

输入

[1,2,3,0.41

输出

3

核心思想是通过在数组上迭代，同时根据元素的值来动态更新正数和负数子序列的长度，以找到最长的正数子序列。程序中的逻辑确保在每次遇到正数或负数时，都会考虑到前面的正数或负数子序列，以正确计算最长连续正数子序列的长度
 */