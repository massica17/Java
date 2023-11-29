package oralTest.yongyou1027;

import java.util.Arrays;
import java.util.HashMap;

public class Test01 {
    public String[] sortByGrad(String[] names, int[] scores){
        HashMap<String, Integer> map = new HashMap<>();
        int size = names.length;
        for(int i = 0; i < size; i++){
            map.put(names[i], scores[i]);
        }
        Arrays.sort(names, (o1, o2) -> map.get(o2) - map.get(o1));
        return names;
    }
}

/*
����һ���ַ�������names����һ���ɻ�����ͬ����������ɵ����� scores��

��������ĳ��Ⱦ�Ϊn��

����ÿ���±�i��names��i�ݺ�scores��i�ݱ�ʾ��i���˵����ֺͳɼ���

�밴�ɼ� ���� ˳�򷵻ض�Ӧ����������names��

ʾ��1

����

["Mary","John","Emma"],[180,165,170]

���

["Mary","Emma","John"]

ʾ��2

����

["Alice","Bob","Bob"],[155,185,150]

���

["Bob","Alice","Bob"]
 */