import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.awt.*;
import java.io.*;
import java.math.BigDecimal;
import java.nio.Buffer;
import java.nio.charset.Charset;
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
        File f = new File("src/answer.txt");
        try(OutputStream fout = Files.newOutputStream(f.toPath());
            OutputStreamWriter writer = new OutputStreamWriter(fout, StandardCharsets.UTF_8);){
            String name = "wo撒旦发射点wo撒旦发射点wo撒旦发射点wo撒旦发射点wo撒旦发射点wo撒旦发射点wo撒旦发射点wo撒旦发射点";
            writer.write(name);
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