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
请补全预设代码中判断回文数的方法，若输入的五位数字是回文是则返回true，否则返回faise。回文数即个位与万位相同，十位与千位相同的数字。如：12321、89898

输入描述

控制台输入的五位数

输出描述

true/false

示例1

输入

12321

输出

true

示例2

输入18182

输出

false
 */