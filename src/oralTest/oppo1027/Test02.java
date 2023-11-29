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
Сŷ�ڴ����ļ��У���Ҫ�����ļ��������֣������ȴ�������Ϊ��abc�����ļ��У���ô��ʱ����һ���ļ�������Ϊ��abc�������������ͬ���ֵ��ļ��У��������ֺ������һ�������������硰abc���Ѿ����ڣ���ô��ʱ�������ļ�������Ϊ��abc(1)���������abc(1)��Ҳ���ڣ���ô��ʱ�������ļ�������Ϊ��abc(2)�����Դ����ơ��������Сŷ�����ļ��С�
 */
