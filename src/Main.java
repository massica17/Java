import org.apache.commons.io.*;

import java.io.*;
import java.nio.file.Path;
import java.util.Properties;
import java.util.Set;

public class Main {
    public static void main(String[] args){
        Thread t = new Thread(() -> {
            int n = 0;
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
            }
        });
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
        }

    }
}
