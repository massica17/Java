package oralTest.nuowaxingyun1026;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();
        String inputs = sc.nextLine();
        sc.close();
        String[] strs = inputs.split(" ");
        Arrays.stream(strs).forEach(item -> map.put(item, map.getOrDefault(item, 0) + 1));
        Arrays.sort(strs, String::compareTo);
        for(String str : strs){
            if(map.containsKey(str)){
                System.out.printf("%s:%d%n", str, map.get(str));
                map.remove(str);
            }
        }
    }
}
/*
��дһ�����򣬸��������һ��Ӣ�ģ����㵥�ʳ��ֵĴ���������������������
 */