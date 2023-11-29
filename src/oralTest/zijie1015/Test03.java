package oralTest.zijie1015;

import oralTest.InputUtils;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Test03 {
    public static void main(String[] args) {
        int[] nums = InputUtils.getArrayBySplit();
        int n = nums[0];
        int[] color = InputUtils.getArrayBySplit();
        int[] shape = InputUtils.getArrayBySplit();
        int[] obtain = InputUtils.getArrayBySplit();
        HashMap<Integer, HashMap<Integer, List<Integer>>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(map.containsKey(color[i])){
                HashMap<Integer, List<Integer>> sameColor = map.get(color[i]);
                if(sameColor.containsKey(shape[i])){
                    List<Integer> sameShape = sameColor.get(shape[i]);
                    sameShape.add(obtain[i]);
                }
                else{
                    List<Integer> sameShape = new ArrayList<>();
                    sameShape.add(obtain[i]);
                    sameColor.put(shape[i], sameShape);
                }
            }
            else{
                HashMap<Integer, List<Integer>> sameColor = new HashMap<>();
                List<Integer> obtainList = new ArrayList<>();
                obtainList.add(obtain[i]);
                sameColor.put(shape[i], obtainList);
                map.put(color[i], sameColor);
            }
        }
        int ans = 0;
        for(Map.Entry<Integer, HashMap<Integer, List<Integer>>> entry : map.entrySet()){
            HashMap<Integer, List<Integer>> tempSameShape = entry.getValue();
            for(Map.Entry<Integer, List<Integer>> entryInner : tempSameShape.entrySet()){
                List<Integer> tempObtain = entryInner.getValue();
                if(tempObtain.size() == 1){
                    ans += tempObtain.get(0);
                }
                else{
                    tempObtain.sort(Integer::compareTo);
                    ans += tempObtain.get(tempObtain.size() - 1);
                    for(int i = tempObtain.size() - 2; i >= 0; i--){
                        ans += tempObtain.get(i) / 2;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
