import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class ReadTxtTest {
    public static void main(String[] args) {
        File f = new File("src/answer.txt");
        try(InputStream is = Files.newInputStream(f.toPath());
            InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr)){
            System.out.println(br.readLine());
        }
        catch (IOException ex){
            ex.printStackTrace();
        }


    }
}
