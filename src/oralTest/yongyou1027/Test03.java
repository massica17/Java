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
����һ�������� n�����n ǡ�������������������� true; ���򣬷� false��

ʾ��1

����

2

���

false

˵��

2 ֻ������������:1��2

˼·�����

ֱ�ӷֽ���ʽ���С�����ǣ����� true�����򣬷��� false��
 */