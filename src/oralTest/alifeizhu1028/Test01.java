package oralTest.alifeizhu1028;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Dish {
    public int price;
    public boolean has;

    public int getPrice() {
        return price;
    }
}

public class Test01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        String hasStr = sc.next();
        Dish[] dishes = new Dish[n];
        for (int i = 0; i < n; i++) {
            dishes[i].price = sc.nextInt();
            if (hasStr.charAt(i) == '1') dishes[i].has = true;
            else dishes[i].has = false;
        }
        sc.close();
        Arrays.sort(dishes, Comparator.comparingInt(Dish::getPrice));
        int cnt = 0;
        int price = 0;
        for (int i = 0; i < n; i++) {
            if (cnt < k) {
                if (!dishes[i].has) {
                    price += dishes[i].price;
                    cnt++;
                } else {
                    if (m > 0) {
                        price += dishes[i].price;
                        cnt++;
                        m--;
                    }
                }
            } else {
                break;
            }
        }
        if(cnt < k) System.out.println(-1);
        else System.out.println(price);
    }
}

/*
С��������һ�ҷ��ݣ��÷���һ����n���ˣ���i���˵ļ۸�Ϊai��������һЩ������Ģ����

С��ϣ����k���ˣ��ܼ۸�ԽСԽ�á�����С�첻ϲ����Ģ������ϣ����Ĳ������m�����а���ĥ����С����֪��������С���ܼ۸��Ƕ��١�

��������

��һ����������������n,m,k���ո������

�ڶ�������һ��01������i���ַ���0����ò˲�����Ģ������1�������Ģ����

����������n������������i��������a[i]

1��m��k��n< 10^5

1��a[i]��10^9

�������

һ�У�������С�ܼ۸����ѡ���������-1.
 */