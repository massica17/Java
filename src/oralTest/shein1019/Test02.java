package oralTest.shein1019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String readLine = br.readLine();
        String[] split = readLine.split(",");
        String str = split[0];
        int row = Integer.valueOf(split[1]);
        br.close();
        int unit = row + row - 2;
        int ls = str.length();
        char[][] map;
        if((ls - row) % unit == 0) map = new char[row][(ls - row) / unit * (row - 1) + 1];
        else map = new char[row][((ls - row) / unit + 1) * (row - 1) + 1];
        int h = 0, w = 0;
        int idx = 0;
        boolean down = true;
        while(idx < ls){
            map[h][w] = str.charAt(idx);
            if(down){
                h++;
                if(h == row){
                    down = false;
                    h-=2;
                    w++;
                }
            }
            else{
                h--;
                w++;
                if(h < 0){
                    down= true;
                    h += 2;
                    w--;
                }
            }
            idx++;
        }
        for(char[] chars : map){
            System.out.println(String.valueOf(chars));
        }
    }
}
