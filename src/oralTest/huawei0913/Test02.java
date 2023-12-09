package oralTest.huawei0913;

import oralTest.InputUtils;

public class Test02 {
    private int[] father;
    private int[] rank;
    public int solve(){
        int m = InputUtils.getLineAsInt();
        int n = InputUtils.getLineAsInt();
        father = new int[m];
        rank = new  int[m];
        for(int i = 0; i < m; i++){
            father[i] = i;
            rank[i] = 1;
        }
        for(int i = 0; i < n; i++){
            int[] arr = InputUtils.getArrayBySplit();
            union(arr[0], arr[1]);
        }
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(father[i] == i) ans ++;
        }
        return ans;
    }

    private int find(int i){
        return father[i] == i ? i : (father[i] = find(father[i]));
    }
    private void union(int i, int j){
        int i_fa = find(i);
        int j_fa=  find(j);
        if(rank[i_fa] <= rank[j_fa]){
            father[i_fa] = j_fa;
        }
        else father[j_fa] = i_fa;
        if(rank[i_fa] == rank[j_fa] && i_fa != j_fa) rank[j_fa] ++;
    }
    public static void main(String[] args) {
        Test02 test02 = new Test02();
        System.out.println(test02.solve());
    }
}
