package oralTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

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
            return readLine.split(",");
        } catch (IOException e) {
            e.printStackTrace();
            return new String[]{};
        }
    }

    public static int[] getArrayBySplitByComma(){
        try{
            String readLine = bufferedReader.readLine().trim();
            return Arrays.stream(readLine.split(",")).mapToInt(Integer::valueOf).toArray();
        } catch (IOException e) {
            e.printStackTrace();
            return new int[]{};
        }
    }
}
