package BaseStruct.Test10;

import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client extends Thread{
    @Override
     public void run(){
        try(Socket socket = new Socket("LocalHost", 6666)){
            OutputStream writer = socket.getOutputStream();
            Scanner sc = new Scanner(System.in);
            System.out.println("��ѡ��Ҫ��ʲô");
            System.out.println("1��ע��");
            System.out.println("2����¼");
            String line = sc.nextLine();
            if(line.equals("1")){
                do{
                    line = sc.nextLine();
                    writer.write(line.getBytes());
                }while (line.equals("exit"));
                System.out.println("�˳�ϵͳ");
            }
            else if(line.equals("2")){
                do{
                    line = sc.nextLine();

                }while (line.equals("exit"));
            }
            else{
                System.out.println("������1����2");
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
