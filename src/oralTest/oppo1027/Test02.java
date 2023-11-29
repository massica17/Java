package oralTest.oppo1027;

import javax.swing.*;
import java.util.HashMap;
import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            String input = sc.nextLine();
            if(map.containsKey(input)){
                int cnt = map.get(input);
                System.out.printf("%s(%d)%n", input, cnt);
                map.put(input, cnt + 1);
            }
            else{
                System.out.println(input);
                map.put(input, 1);
            }
        }
        sc.close();
    }
}
/*
小欧在创建文件夹，需要输入文件决的名字，比如先创建名字为“abc”的文件夹，那么此时就有一个文件夹名字为“abc”。如果存在相同名字的文件夹，则在名字后面加上一个正整数，比如“abc”已经存在，那么此时创建的文件夹名字为“abc(1)”。如果“abc(1)”也存在，那么此时创建的文件夹名字为“abc(2)”。以此类推。请你帮助小欧创建文件夹。
 */
