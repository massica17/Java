package oralTest.jingdong0928;

import oralTest.InputUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Test02 {
    public int solve() {
        int[] array = InputUtils.getArrayBySplit();
        int n = array[0];
        int m = array[1];
        int k = array[2];
        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = InputUtils.getLine().toCharArray();
        }
        if (n < 1) return 0;
        int[][] cnt = new int[n][m];
        List<Integer> cntList = new ArrayList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(j == 0){
                    cnt[j][i] = map[j][i] == '*' ? -1 : 0;
                }
                else{
                    cnt[j][i] = map[j][i] == '*' ? -1 : cnt[j - 1][i] + 1;
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(j + 1 == n && cnt[j][i] > 0){
                    cntList.add(cnt[j][i]);
                }
                else if(j + 1 < n && map[j + 1][i] == '*' && cnt[j][i] > 0){
                    cntList.add(cnt[j][i]);
                }
            }
        }
        cntList.sort(((o1, o2) -> o2 - o1));
        int ans = 0;
        for (Integer integer : cntList) {
            if (k >= integer + 1) {
                ans += integer;
                k -= integer + 1;
            } else if(k > 0){
                ans += k - 1;
                break;
            }
            else break;
        }
        return ans;
    }

    public static void main(String[] args) {
        Test02 test02 = new Test02();
        System.out.println(test02.solve());
    }
}
