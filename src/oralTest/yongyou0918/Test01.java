package oralTest.yongyou0918;

import java.util.*;

public class Test01 {
    public List<Integer> solve(int n, int[][] meetings, int firstPerson) {
        int[] person = new int[n];
        Arrays.fill(person, -1);
        person[0] = 0;
        person[firstPerson] = 0;
        Arrays.sort(meetings, Comparator.comparingInt(o -> o[2]));
        for (int i = 0; i < meetings.length; i++) {
            int[] meeting = meetings[i];
            if(person[meeting[0]] != -1){
                person[meeting[1]] = person[meeting[1]] == -1 ? meeting[2] : person[meeting[1]];
            }
            else if(person[meeting[1]] != -1){
                person[meeting[0]] = meeting[2];
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(person[i] != -1){
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] meetings = new int[][]{{1, 2, 5}, {2, 3, 8}, {1, 5, 101}};
        int firstPerson = 1;
        Test01 test01 = new Test01();
        System.out.println(test01.solve(n, meetings, firstPerson));
    }
}
