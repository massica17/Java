package oralTest.tongcheng0916;

import oralTest.InputUtils;
import oralTest.Main;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.TemporalField;
import java.util.Arrays;
import java.util.OptionalInt;

public class Test02 {
    public int solve1(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            if(i == 0){
                maxLen = Math.max(maxLen, findFirstSmallOrEqual(arr, arr[i], k, i) + 1);
            }
            else if(i == n - 1){
                maxLen = Math.max(maxLen, findFirstBigOrEqual(arr, arr[i], k, i) + 1);
            }
            else{
                maxLen = Math.max(maxLen, findFirstSmallOrEqual(arr, arr[i], k, i) - findFirstBigOrEqual(arr, arr[i], k, i) + 1);
            }
        }
        return maxLen;
    }

    public int findFirstBigOrEqual(int[] arr, int val, int k, int cur) {
        val -= k;
        int left = 0, right = cur;
        int mid;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (arr[mid] < val) {
                left = mid + 1;
            } else right = mid - 1;
        }
        return left;
    }

    public int findFirstSmallOrEqual(int[] arr, int val, int k, int cur) {
        val += k;
        int left = cur, right = arr.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) >> 1;
            if(arr[mid] > val){
                right = mid - 1;
            }
            else left = mid + 1;
        }
        return right;
    }

    public int solve2(int[] arr, int k){
        int n = arr.length;
        int max = Arrays.stream(arr).max().orElse(Integer.MIN_VALUE);
        int min = Arrays.stream(arr).min().orElse(Integer.MAX_VALUE);
        int[] diff = new int[max + k - (min - k) + 2];
        for(int num : arr){
            diff[num - k - (min - k)] += 1;
            diff[num + k - (min - k) + 1] -= 1;
        }
        int preSum = 0;
        int ans = 0;
        for(int num : diff){
            preSum += num;
            ans = Math.max(ans, preSum);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] array = InputUtils.getArrayBySplitByComma();
        int k = InputUtils.getLineAsInt();
        System.out.println(new Test02().solve1(array, k));
        System.out.println(new Test02().solve2(array, k));
    }
}
