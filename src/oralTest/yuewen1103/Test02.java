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
����һ������Ϊn���������飬�����ҳ�������ĳ˻�Ϊ�����������鳤�ȡ�������Ķ�����ԭ������һ�����ȵ�����������ɵ����顣

���ݷ�Χ��1<n��10^5�������е�Ԫ������|val|��10���10^9

ʾ��1

����

[1,2,3,-1,4]

���

3

ʾ��2

����

[1,2,3,0.41

���

3

����˼����ͨ���������ϵ�����ͬʱ����Ԫ�ص�ֵ����̬���������͸��������еĳ��ȣ����ҵ�������������С������е��߼�ȷ����ÿ��������������ʱ�����ῼ�ǵ�ǰ����������������У�����ȷ������������������еĳ���
 */