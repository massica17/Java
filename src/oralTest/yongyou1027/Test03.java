package oralTest.yongyou1027;

import java.util.HashSet;
import java.util.Set;

public class Test03 {
    public boolean isThree(int n) {
        Set<Integer> set = new HashSet<>();
        for(int i = 1;i * i <= n;i++) {
            if(n % i == 0) {
                set.add(i);
                set.add(n / i);
            }
        }
        if(set.size() == 3) {
            return true;
        }
        return false;
    }

}

/*
给定一个正整数 n，如果n 恰好有三个正除数，返回 true; 否则，返 false。

示例1

输入

2

输出

false

说明

2 只有两个正除数:1和2

思路与代码

直接分解因式就行。如果是，返回 true；否则，返回 false。
 */