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
            System.out.println("请选择要做什么");
            System.out.println("1、注册");
            System.out.println("2、登录");
            String line = sc.nextLine();
            if(line.equals("1")){
                do{
                    line = sc.nextLine();
                    writer.write(line.getBytes());
                }while (line.equals("exit"));
                System.out.println("退出系统");
            }
            else if(line.equals("2")){
                do{
                    line = sc.nextLine();

                }while (line.equals("exit"));
            }
            else{
                System.out.println("请输入1或者2");
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
