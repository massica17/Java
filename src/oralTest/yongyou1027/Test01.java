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
给定一个字符串数组names，和一个由互不相同的正整数组成的数组 scores。

两个数组的长度均为n。

对于每个下标i，names［i］和scores［i］表示第i个人的名字和成绩。

请按成绩 降序 顺序返回对应的名字数组names。

示例1

输入

["Mary","John","Emma"],[180,165,170]

输出

["Mary","Emma","John"]

示例2

输入

["Alice","Bob","Bob"],[155,185,150]

输出

["Bob","Alice","Bob"]
 */