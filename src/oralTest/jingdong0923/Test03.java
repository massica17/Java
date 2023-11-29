package oralTest.jingdong0923;

import oralTest.InputUtils;

import java.util.*;

public class Test03 {
    public int solve(int n, int[] arr){
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if((i & 1) == 0) even.add(arr[i - 1]);
            else odd.add(arr[i - 1]);
        }
        List<Integer> oddCopy = new ArrayList<>(odd);
        List<Integer> evenCopy = new ArrayList<>(even);
        Arrays.sort(arr);
        odd.sort(Integer::compareTo);
        even.sort(Integer::compareTo);
        int idx1 = 0;
        int idx2 = 0;
        for(int i = 0; i < n; i++){
           if(((i + 1) & 1) == 1){
               if(arr[i] != odd.get(idx1)){
                   return -1;
               }
               else{
                   idx1++;
               }
           }
           else{
               if(arr[i] != even.get(idx2)){
                   return -1;
               }
               else{
                   idx2++;
               }
           }
        }

        return cntSwapTime(oddCopy) + cntSwapTime(evenCopy);
    }

    private int cntSwapTime(List<Integer> arr) {
        List<Integer> arrCopy = new ArrayList<>(arr);
        arrCopy.sort(Integer::compareTo);
        int size = arrCopy.size();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < size; i++){
            map.put(arrCopy.get(i), i);
        }
        boolean[] use = new boolean[size];
        int loops = 0;
        for(int i = 0; i < size; i++){
            if(!use[i]){
                int j = i;
                while(!use[j]){
                    use[j] = true;
                    j = map.get(arr.get(j));
                }
                loops++;
            }
        }
        return size - loops;
    }

    public static void main(String[] args) {
        int n = InputUtils.getLineAsInt();
        int[] arr = InputUtils.getArrayBySplit();
        Test03 test03 = new Test03();
        System.out.println(test03.solve(n, arr));
    }
}

/*
将数列变为有序的最少交换次数
给一个数列问将其排序递增或者递减序列的最小交换次数。

一。 只能交换相邻元素

　　　　该情况下最少交换次数即为逆序数的数目，求逆序数只要从1~n遍历数组，每次添加一个数字到树状数组然后求前缀和即可

二。可以交换任意位置的元素

　　　　例如2 4 3 1，可以知道1应该与2交换，而2应该与4交换，4应该与1交换，这样就形成一个循环(3应该与本身交换可以看作自环)，易知这样的循环中如果有x个数，只要交换x-1次就能将这个循环内的大小顺序排好，而不同的循环之间是不会影响的，所以假如n个数有k个循环，每个循环有ai个数，则交换次数应该为(a1-1)+ (a2-1) + ... + (ak-1) = n-k，即数组数目减循环个数，求循环个数直接对数组建图然后dfs一遍即可
 */