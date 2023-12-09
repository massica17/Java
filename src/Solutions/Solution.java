package Solutions;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode father;

    TreeNode(int x) {
        val = x;
    }
}

class ListNode{
    int val;
    ListNode next;
    public ListNode(int x){val = x; }

    public static ListNode buildLinkedList(int[] nums){
        ListNode head = new ListNode(nums[0]);
        ListNode temp = head;
        for(int i = 1; i < nums.length; i++){
            temp.next = new ListNode(nums[i]);
            temp = temp.next;
        }
        return head;
    }
}

public class Solution {
    public static List<Character> pc;
    public static List<Integer> pn;
    public static String s = null;

    public static boolean backTracking(int si, int slen, int pi, int plen){
        if(si == slen){
            while(pi < plen){
                System.out.printf("%d %c %n",pi, pc.get(pi));
                if(pn.get(pi) != 2) return false;
                pi++;
            }
            return true;
        }
        System.out.printf("%d %c  %d %c %n",si, s.charAt(si), pi, pc.get(pi));
        if(si < slen && pi == plen) return false;

        if(pn.get(pi) == 2){
            if(pc.get(pi) == '.' || pc.get(pi) == s.charAt(si)){
                return backTracking(si + 1, slen, pi + 1, plen) ||
                        backTracking(si, slen, pi + 1, plen) ||
                        backTracking(si + 1, slen, pi, plen);
            }
            else return backTracking(si, slen, pi + 1, plen);
        }
        else if(pc.get(pi) == s.charAt(si) || pn.get(pi) == 1){
            return backTracking(si + 1, slen, pi + 1, plen);
        }
        return false;
    }
    public boolean isMatchBfs(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        pc = new ArrayList<>();
        pn = new ArrayList<>();
        Solution.s = s;
        int i = 0;
        while(i < plen){
            if(i + 1 < plen && p.charAt(i + 1) == '*'){
                pc.add(p.charAt(i));
                pn.add(2);
                i += 2;
            }
            else{
                pc.add(p.charAt(i));
                if(p.charAt(i) == '.'){
                    pn.add(1);
                }
                else{
                    pn.add(0);
                }
                i ++;
            }
        }
        System.out.println(pc);
        System.out.println(pn);
        return backTracking(0, slen, 0, pc.size());
    }

    public boolean isMatch(String s, String p){
        int slen = s.length();
        int plen = p.length();
        pc = new ArrayList<>();
        pn = new ArrayList<>();
        Solution.s = s;
        int i = 0;
        while(i < plen){
            if(i + 1 < plen && p.charAt(i + 1) == '*'){
                pc.add(p.charAt(i));
                pn.add(2);
                i += 2;
            }
            else{
                pc.add(p.charAt(i));
                if(p.charAt(i) == '.'){
                    pn.add(1);
                }
                else{
                    pn.add(0);
                }
                i ++;
            }
        }
        System.out.println(pc);
        System.out.println(pn);
        plen = pc.size();
        boolean[][] dp = new boolean[slen + 1][plen + 1];
        dp[0][0] = true;
        i = 1;
        while(i <= plen && pn.get(i - 1) == 2){
            dp[0][i] = true;
            i ++;
        }
        System.out.println(Arrays.toString(dp[0]));
        for(i = 1; i <= slen; i++){
            for(int j = 1; j <= plen; j++){
                if(pn.get(j - 1) == 2){
                    if(pc.get(j - 1) == '.' || pc.get(j - 1) == s.charAt(i - 1)){
                        dp[i][j] = dp[i][j - 1] || dp[i - 1][j - 1] || dp[i - 1][j];
                    }
                    else dp[i][j] = dp[i][j - 1];
                }
                else if(pn.get(j - 1) == 1){
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else if(pn.get(j - 1) == 0){
                    dp[i][j] = dp[i - 1][j - 1] && s.charAt(i - 1) == pc.get(j - 1);
                }
            }
        }
        return dp[slen][plen];
    }


    public static void main(String[] args) {
        Integer i1 = 40;
        Integer i2 = new Integer(40);
        System.out.println(i1==i2);
    }
}