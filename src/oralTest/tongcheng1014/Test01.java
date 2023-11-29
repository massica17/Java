package oralTest.tongcheng1014;

import java.util.*;

public class Test01 {
    public int[] getAns(int[] a, int[] b){
        HashSet<Integer> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        Arrays.stream(a).forEach(set::add);
        Arrays.stream(b).forEach(item -> {
            if(set.contains(item)){
                res.add(item);
            }
        });
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
