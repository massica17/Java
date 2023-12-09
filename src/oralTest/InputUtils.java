package oralTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputUtils {
    public static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static String getLine() {
        try {
            return bufferedReader.readLine().trim();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static int getLineAsInt() {
        try {
            return Integer.parseInt(bufferedReader.readLine().trim());
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int[] getArrayBySplit(){
        try{
            String line = bufferedReader.readLine().trim();
            return Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        catch (IOException e){
            e.printStackTrace();
            return new int[]{};
        }
    }
    public static char[] getCharArrayBySplit(){
        try{
            String readLine = bufferedReader.readLine().trim();
            StringBuffer stringBuffer = new StringBuffer();
            for(int i = 0; i <readLine.length(); i++){
                if(readLine.charAt(i) != ' ') stringBuffer.append(readLine.charAt(i));
            }
            return stringBuffer.toString().toCharArray();
        } catch (IOException e) {
            e.printStackTrace();
            return new char[]{};
        }
    }

    public static String[] getStringArrayBySplit(){
        try{
            String readLine = bufferedReader.readLine().trim();
            return readLine.split(" ");
        } catch (IOException e) {
            e.printStackTrace();
            return new String[]{};
        }
    }



    public static String[] getStringArrayBySplitByComma(){
        try{
            String readLine = bufferedReader.readLine().trim();
            readLine = readLine.substring(1);
            readLine = readLine.substring(0,readLine.length() - 1);
            return readLine.split(",");
        } catch (IOException e) {
            e.printStackTrace();
            return new String[]{};
        }
    }

    public static int[] getArrayBySplitByComma(){
        try{
            String readLine = bufferedReader.readLine().trim();
            readLine = readLine.substring(1);
            readLine = readLine.substring(0,readLine.length() - 1);
            return Arrays.stream(readLine.split(",")).mapToInt(Integer::valueOf).toArray();
        } catch (IOException e) {
            e.printStackTrace();
            return new int[]{};
        }
    }
}
