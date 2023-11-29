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
�����б�Ϊ��������ٽ�������
��һ�������ʽ�������������ߵݼ����е���С����������

һ�� ֻ�ܽ�������Ԫ��

������������������ٽ���������Ϊ����������Ŀ����������ֻҪ��1~n�������飬ÿ�����һ�����ֵ���״����Ȼ����ǰ׺�ͼ���

�������Խ�������λ�õ�Ԫ��

������������2 4 3 1������֪��1Ӧ����2��������2Ӧ����4������4Ӧ����1�������������γ�һ��ѭ��(3Ӧ���뱾�������Կ����Ի�)����֪������ѭ���������x������ֻҪ����x-1�ξ��ܽ����ѭ���ڵĴ�С˳���źã�����ͬ��ѭ��֮���ǲ���Ӱ��ģ����Լ���n������k��ѭ����ÿ��ѭ����ai�������򽻻�����Ӧ��Ϊ(a1-1)+ (a2-1) + ... + (ak-1) = n-k����������Ŀ��ѭ����������ѭ������ֱ�Ӷ����齨ͼȻ��dfsһ�鼴��
 */