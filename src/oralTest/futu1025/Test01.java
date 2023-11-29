package oralTest.futu1025;

import java.util.Arrays;
import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] an = new int[n];
        int[] bm = new int[m];
        for(int i = 0; i < n; i++) an[i] = sc.nextInt();
        for(int j = 0; j < m; j++) bm[j] = sc.nextInt();
        Arrays.sort(bm);
        int ans = 0;
        for (int a : an){
            if(positive(bm, a)){
                ans ++;
            }
        }
        System.out.println(ans);
    }

    private static boolean positive(int[] bm, int a) {
        int left = 0;
        int right = bm.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if(bm[mid] == a) {
                return false;
            }
            if(bm[mid] > a){
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return (bm.length - (left)) % 2 == 0;
    }
}
