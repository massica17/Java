package oralTest.yuewen1103;

public class Test01 {
    public boolean isPalindrome (int nums){
        String str = String.valueOf(nums);
        int left = 0;
        int right = str.length() - 1;
        while(left < right){
            if(str.charAt(left) == str.charAt(right)){
                left++;
                right--;
            }
            else return false;
        }
        return true;
    }
}

/*
�벹ȫԤ��������жϻ������ķ��������������λ�����ǻ������򷵻�true�����򷵻�faise������������λ����λ��ͬ��ʮλ��ǧλ��ͬ�����֡��磺12321��89898

��������

����̨�������λ��

�������

true/false

ʾ��1

����

12321

���

true

ʾ��2

����18182

���

false
 */