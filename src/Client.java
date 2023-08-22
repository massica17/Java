import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try(DatagramSocket socket = new DatagramSocket()){
            Scanner sc = new Scanner(System.in);
            while(true){
                String line = sc.nextLine();
                if("exit".equals(line)) break;
                byte[] bytes = line.getBytes();
                DatagramPacket dp = new DatagramPacket(bytes, bytes.length, InetAddress.getLocalHost(), 6666);
                socket.send(dp);
                System.out.println("send " + line);
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
