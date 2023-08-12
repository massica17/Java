import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args)  throws IOException {
        int[] a = new int[]{1, 2, 3, 4, 5, 5};
        IntStream is = Arrays.stream(a).distinct();
        System.out.println(is.count());
    }
}
