import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    public static void main(String[] args) {
        try(DatagramSocket ds = new DatagramSocket(6666)){
            int count  = 0;
            do {
                byte[] buffer = new byte[1024 * 64];
                DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
                ds.receive(dp);
                System.out.println(new String(buffer, 0, dp.getLength()));
                System.out.println(ds.getPort());
                count++;
            } while (count <= 10);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
