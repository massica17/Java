import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class WriteTest {
    public static void main(String[] args) {
        File f = new File("src/answer.txt");
        File f = new Fil
        try(OutputStream out = Files.newOutputStream(f.toPath());
            OutputStreamWriter outw = new OutputStreamWriter(out, StandardCharsets.UTF_8);
            BufferedWriter bw = new BufferedWriter(outw)){
            bw.write("wo撒旦发射点wo撒旦发射点wo撒旦发射点wo撒旦发射点wo撒旦发射点wo撒旦发射点wo撒旦发射点wo撒旦发射点wo撒旦发射点");
        }
        catch (IOException ex){
            ex.printStackTrace();
        }

    }
}
