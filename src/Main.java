// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                int count = 1;
                while(true){
                    System.out.printf("%d, ", count);
                }
            }
        };
        Thread t = new Thread(r);
        t.start();
    }
}