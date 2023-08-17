import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        String name = "asdf我是";
        byte[] bytes = name.getBytes(StandardCharsets.UTF_8);
        String newname = new String(bytes, StandardCharsets.UTF_8);
        File f = new File(Paths.get("src", "answer.txt").toUri());
        System.out.println(f.length());

        try (FileInputStream fin = new FileInputStream(f)) { //try-with-resources会自动关闭打开的外部资源

        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
}

class Student{
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}